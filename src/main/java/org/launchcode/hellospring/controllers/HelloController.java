package org.launchcode.hellospring.controllers;

import com.sun.org.apache.regexp.internal.RE;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class HelloController {

    @RequestMapping(value = "")
    @ResponseBody
    public String index(HttpServletRequest request) {

        String name = request.getParameter("name");
        if (name == null) {
            name = "World";
        }
        return "Hello " + name;
    }

    @RequestMapping(value = "hello", method = RequestMethod.GET)
    @ResponseBody
    public String helloform(){

        String html = "<form method='post'>" +
                "<input type ='text' name='name' />" +
                "<select name='language'>" +
                    "<option value='english'>English</option>" +
                    "<option value='french'>French</option>" +
                    "<option value='german'>German</option>" +
                    "<option value='spanish'>Spanish</option>" +
                    "<option value='swedish'>Swedish</option>"+
                "<input type='submit' value='Greet Me!' />" +
                "</form>";
        return html;
    }

    /**
    @RequestMapping(value = "hello" , method = RequestMethod.POST)
    @ResponseBody
    public String helloPost(HttpServletRequest request){
        String name = request.getParameter("name");
        return "Hello " + name;
    }
     */

    @RequestMapping(value = "hello" , method = RequestMethod.POST)
    @ResponseBody
    public String createMessage(HttpServletRequest request){
        String name = request.getParameter("name");
        String language = request.getParameter("language");

        if (language.equals("english")) {
            return "Hello " + name;
        } else if (language.equals("french")){
            return "Bonjour " + name;
        } else if (language.equals("german")){
            return "Hallo " + name;
        } else if (language.equals("spanish")){
            return "Hola " + name;
        } else if (language.equals("swedish")){
            return "Halla " + name;
        }
        return "hello " + name;
    }


    @RequestMapping(value = "hello/{name}")
    @ResponseBody
    public String helloUrlSegment(@PathVariable String name){
        return "Hello " + name;
    }

    @RequestMapping(value = "goodbye")
    public String goodbye() {
        return "redirect:/";
    }
}


