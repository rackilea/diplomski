package com;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;
public class UserController extends MultiActionController {
    public ModelAndView add1(HttpServletRequest request,
            HttpServletResponse response) {
        return new ModelAndView("page1", "message", "hi this is page1");
    }
    public ModelAndView add2(HttpServletRequest request,
            HttpServletResponse response) {
        return new ModelAndView("page2", "message", "hi this is page2");
    }

}