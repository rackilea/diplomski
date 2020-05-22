@RequestMapping(value = "/resetPassword", method = RequestMethod.POST)
public ModelAndView setNewPassword(@RequestBody @Valid PasswordUpdateRq passwordUpdateRq) {
  User user = userService.findUserByResetToken(passwordUpdateRq.getToken());

  ModelAndView modelAndView = new ModelAndView();
  modelAndView.addObject("message", "Form data is " + passwordUpdateRq.getToken() + passwordUpdateRq.getPassword() + user.getEmail());
  modelAndView.setViewName("resetPassword");

  return modelAndView;
}