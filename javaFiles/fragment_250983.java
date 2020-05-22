@RequestMapping(value= "/registeruser_action", method = RequestMethod.POST)
public String addUser(@ModelAttribute("AppUser") @Valid AppUser appUser, @ModelAttribute("roleList") RoleList roleList, BindingResult result){

    if(result.hasErrors()){
        return "register";
    }

    for(RoleWrapper role : roleList.getRoles()){
        if(role.isSelected()){
            //add to user
        }
    }

    appUserDetailsService.registerUser(appUser);


    return "redirect:/menu";    
}