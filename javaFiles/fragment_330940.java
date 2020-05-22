@RequestMapping("/request")
public ModelAndView getRequest(@ModelAttribute User user, ModelAndView mv, HttpSession session) {
     mv.addObject("reset_user_email", user.getEmail());

     session.setAttribute("reset_user_email", user.getEmail());
     String resetUserEmail = session.getAttribute("reset_user_email");         
}