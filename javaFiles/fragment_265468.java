@RequestMapping(value = { "/register" }, method = RequestMethod.GET)
public ModelAndView register(){
    ModelAndView modelAndView = new ModelAndView();

    modelAndView.addObject("User", new User());

    modelAndView.setViewName("register"); // resources/templates/register.html
    return modelAndView;