@RequestMapping(value = "/registrationConfirm.html",method = RequestMethod.POST)
public ModelAndView registration(@Valid @ModelAttribute("user") User user,
                            BindingResult result){
    if(result.hasErrors()){
        return new ModelAndView("registration");
    }
    if(userService.registerUser(user)){
        ModelAndView modelAndView = new ModelAndView("login");
        modelAndView.addObject("resultRegistration", "Success registration!");
        return modelAndView;
    }
    //If the other cases didn't hold true, it means the registration failed
    ModelAndView modelAndView = new ModelAndView("registration");
    modelAndView.addObject("resultRegistration", 
        "User with the same login or password is registered in system already");
    return modelAndView;
}