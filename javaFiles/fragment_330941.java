@RequestMapping("/request")
public ModelAndView getRequest(@ModelAttribute User user, ModelAndView mv, HttpServletRequest request) {
     mv.addObject("reset_user_email", user.getEmail());

     WebUtils.setSessionAttribute(request, "reset_user_email", user.getEmail());
     String resetUserEmail = WebUtils.getSessionAttribute(request, "reset_user_email");  
}