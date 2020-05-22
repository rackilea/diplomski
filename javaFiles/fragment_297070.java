@RequestMapping(value="/register", method = RequestMethod.GET)
public String showRegister(Model model) {
     ....
    if (!model.containsAttribute("form")) {
        model.addAttribute("form", new RegistrationForm());
    }
    .....
}