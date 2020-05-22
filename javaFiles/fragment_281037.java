@GetMapping("/")
public String index(Model model) {

    UserDetails principal = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

    User user = this.userRepository.findByEmail(principal.getUsername());

    model.addAttribute("user", user);
    model.addAttribute("view", "home/index");

    return "layout";
}