@RequestMapping(value = "/logout", method = RequestMethod.GET)
public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
  Authentication auth = SecurityContextHolder.getContext().getAuthentication();
  if (auth != null) {
    new SecurityContextLogoutHandler().logout(request, response, auth);
  }
  return "redirect:/login?logout";
}