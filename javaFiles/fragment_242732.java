@GetMapping("users/{id}")
public String editUser(@PathVariable long id,  Model model, HttpSession session)
{
    User user = userService.findByID(id);
    Iterable<Role> roles= roleService.findAll();
    UserEditForm userEditForm = new UserEditForm(user);
    model.addAttribute("userEditForm", userEditForm);
    model.addAttribute("allRoles", roles);
    session.setAttribute("allRoles", roles);
    return "admin/userEdit";
}

@PostMapping("users/{id}")
public String updateUser(@PathVariable long id, @ModelAttribute UserEditForm userEditForm,
                         BindingResult bindingResult, @SessionAttribute("allRoles") Iterable<Role> roles,
                         Model model, SessionStatus sessionStatus)
{
    userEditValidator.validate(userEditForm, bindingResult);


    if (bindingResult.hasErrors()) {
        model.addAttribute("allRoles", roles);
        return "admin/userEdit";
    }

    User user = new User(userEditForm);
    userService.save(user);
    sessionStatus.setComplete();
    return "redirect:/admin/users";
}