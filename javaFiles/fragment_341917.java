package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UiRootController {
  @RequestMapping(value = "/*")
  public ModelAndView mainPage() {
    return new ModelAndView("index");
  }

  @RequestMapping(value={"/other"})
  public ModelAndView otherPage() {
    return new ModelAndView("other");
  }
}