import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class WelcomeController {



    @RequestMapping("/testpost" )
    @PostMapping
    @ResponseBody
    public String testPost(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        return name;
        //return "welcome"; //if you want to return jsp
    }

    @RequestMapping("/testget" )
    @PostMapping
    @ResponseBody
    public String testGet(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        return name;
        ///return "welcome";
    }

}