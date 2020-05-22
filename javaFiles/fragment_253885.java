@RequestMapping(value = "/login")
public ModelAndView mainPage(RedirectAttributes redirectAttrs){
    Map<String> attributesMap = redirectAttrs.getFlashAttributes();

    return new ModelAndView("/login");

}

@RequestMapping(value = "/check")
public View checkLogin(RedirectAttributes redirectAttributes,
                       @RequestHeader(value = "username", required = false)String username,
                       @RequestHeader(value = "password", required = false)String password){

    redirectAttributes.addFlashAttribute("error", "Test message");
    return new RedirectView("/login");

}