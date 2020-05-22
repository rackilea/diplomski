@GetMapping("/profile")
public ModelAndView getProfile(HttpServletRequest request) {
    HttpSession session = request.getSession(false);
    User user = userService.getProfile(email);
    session.setAttribute("user", user);
    ModelAndView model = new 
    ModelAndView(NAME_OF_THYMELEAF_PROFILE_FILE);
    model.addObject("session",session);
    return model;
}