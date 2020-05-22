public String save(@Valid @ModelAttribute("user") final User user,
        BindingResult result) throws Exception
{
    if (result.hasErrors()) {
        return "addUser";
    } else {
        handler.saveUser(user);
        return "redirect:/userList";
   }
}