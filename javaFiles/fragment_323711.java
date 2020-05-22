package com.learnspring.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/")
public class OffersController {
    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView homeGet(HttpServletRequest request) {
        System.out.println("Check mapping");
        ModelAndView model = new ModelAndView("home");
        return model;
    }
}