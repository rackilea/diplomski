@RequestMapping(value = "/registration", method = RequestMethod.POST)
public String getRegistrationForm( //
    @ModelAttribute("registrationAttribute") Registration registration, //
    BindingResult result, Model model) {
  ...
  return ...
}