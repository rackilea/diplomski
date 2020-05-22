@GetMapping("/allSubjects")
public String shoSubjects(@ModelAttribute("subject") @Valid UserRegistrationDto userDto, BindingResult result, Model model) {
    Authentication loggedInUser = SecurityContextHolder.getContext().getAuthentication();
    String email = loggedInUser.getName();   
    User user = userRepository.findByEmailAddress(email);

    model.addAttribute("subjects", user.getSubject());
    return "allSubjects";
}