package com.programcreek.helloworld.controller;

    import org.springframework.stereotype.Controller;
    import org.springframework.ui.ModelMap;
    import org.springframework.validation.BindingResult;
    import org.springframework.web.bind.annotation.ModelAttribute;
    import org.springframework.web.bind.annotation.RequestMapping;
    import org.springframework.web.bind.annotation.RequestMethod;
    import org.springframework.web.servlet.ModelAndView;

    @Controller
    @RequestMapping("/")
    public class StudentController {

        @RequestMapping(value = "/student", method = RequestMethod.GET)
           public ModelAndView student() {

              return new ModelAndView("student", "command2", new Student());
           }



           @RequestMapping(value = "/addStudent", method = RequestMethod.POST)
           public ModelAndView addStudent(@ModelAttribute("HelloWorld")Student student) {
               ModelAndView modelAndView = new ModelAndView();

               System.out.println("Controller2");
               modelAndView.addObject("name", student.getName());
               modelAndView.addObject("age", student.getAge());
               modelAndView.addObject("id", student.getId());
               modelAndView.setViewName("result");


              return modelAndView;
           }
        }