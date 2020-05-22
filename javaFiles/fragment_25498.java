package com.12345;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("")
public class HomeController {

  static Logger log = Logger.getLogger(HomeController.class.getName());

    @RequestMapping("/a")
    public String home() {
    log.debug("a route reached");
        return "Home";
    }
}