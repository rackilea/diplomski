@RequestMapping(value="/login.do", method=RequestMethod.POST)
    public ModelAndView login(@Valid User user){
        ModelAndView mv = new ModelAndView("redirect:result.html");
        if (authService.authenticate(user.getUserName(), user.getPassword()))
            mv.addObject("flashScope.message", "Success");
        //else
            mv.addObject("flashScope.message", "Login Failed");
        return mv;
    }

@RequestMapping(value ="/result.html", method=RequestMethod.GET)
    public ModelAndView result(){
        ModelAndView mv = new ModelAndView("login/loginAction");
        return mv;
    }