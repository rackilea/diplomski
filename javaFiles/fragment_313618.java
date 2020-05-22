@GetMapping("/profile")
public ModelAndView getProfile(HttpServletRequest request) {
    User user = userService.getProfile(email);
    ModelAndView model = new ModelAndView(NAME_OF_THYMELEAF_PROFILE_FILE);
    model.addObject("user",user);
    return model;
}