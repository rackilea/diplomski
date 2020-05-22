RegistrationController {

  @RequestMapping(value = "/save-user", method = RequestMethod.POST)
  public ModelAndView saveUser(UserBean user, HttpSession session) {

    // Store user object in the user's session
    session.setAttribute("user", user);

    // Return back some information for showing purpose only
    Map<String, String> result = new HashMap<String, String>();
    result.put("email", user.getEmail());
    result.put("id", String.valueOf(user.getId()));
    result.put("login", user.getLogin());
    return new ModelAndView("privateroom", result);
  }

}