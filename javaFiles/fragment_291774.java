@RequestMapping(value = "/saveUser/{id}", method = RequestMethod.POST)
public String saveUser(@ModelAttribute("user") User user, @PathVariable Long id, Model model) {
    userRepo.save(user); //JPA Repo

    if(user == null)         // check if user object is empty
       user = new User();    // if user is empty, then instantiate a new user object

    model.addAttribute("user", user);

    return "success";
}