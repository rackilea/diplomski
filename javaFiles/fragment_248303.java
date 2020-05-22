@RequestMapping(method = RequestMethod.PUT, produces = "text/html")
public String update(@Valid AppUser appUser, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
    System.out.println("On Update - " + appUser);
    if (bindingResult.hasErrors()) {
        populateEditForm(uiModel, appUser);
        return "users/update";
    }
    uiModel.asMap().clear();
    User attached = User.findUserById(user.getId());
    appUser.setPassword_encoded(attached..getPassword());
    appUser.merge();
    return "redirect:/users/" + encodeUrlPathSegment(appUser.getId().toString(), httpServletRequest);
}