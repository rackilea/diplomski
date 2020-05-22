package com.app.controller;

import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping(value = "/test")
public class TestController
{

    @RequestMapping(value = "/{action:[A-Za-z\\d]+}.do")
    public @ResponseBody
    ModelAndView getDo(@PathVariable String action)
    {
        return new ModelAndView("redirect:/test/action/" + action);
    }

    @RequestMapping(value = "/action/a")
    public @ResponseBody
    ModelAndView getAction()
    {
        return new ModelAndView("/index.jsp");
    }

}