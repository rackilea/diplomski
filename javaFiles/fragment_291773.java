@RequestMapping(value = "/saveUser/{id}", method = RequestMethod.POST)
public String saveUser(@ModelAttribute("user") User user, @PathVariable Long id, Model model) {
    model.addAttribute("user", user);
    userRepo.save(user); //JPA Repo
    return "success";
}