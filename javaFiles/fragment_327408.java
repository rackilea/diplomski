@RequestMapping(value = "/log_in", method = RequestMethod.POST)
public ModelAndView tryToLogin(@RequestParam("uName") String uName, @RequestParam("pW") String pW,      HttpServletResponse response, HttpServletRequest request) {
    ModelAndView ret = new ModelAndView("login", "command", new User());
    User user = userService.existingUser(uName, pW);
    loggedInUser = new User();
    model.addAttribute("command", new Comment());
    if (user != null) {
        Map<String, Object> model = new HashMap<String, Object>();
            model.put("COMMENTS", allComments);
            model.put("LOGGED_IN_USER", loggedInUser);
        ret = ModelAndView("showAllComments", model);
    }
    return ret;
}