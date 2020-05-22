@RequestMapping(value = "/registration", method = RequestMethod.GET)
public String registartionPage(Model model) {

Registration registration = new Registration();

model.addAttribute("registration", registration);

return "registarion/registarion";
}

@RequestMapping(value = "/user/new-user-registrn", method = RequestMethod.POST)
public String newUserRegistrn(Model model, @ModelAttribute("registration") 
Registration registration, RedirectAttributes redirectAttributes) {

try {

    StarUser user = starSecurityService.findSysUserName(registration.getUserName());
    if (user != null) {
        throw new Exception("User Already Exist. Please try with different User Name");
    }

    user = (StarUser) starUtilService.save(setStarUser(registration));
    model.addAttribute("registration", registration);
    if (user != null) {

        redirectAttributes.addAttribute("starMessage",
            "Your Account is successfully created !! Login to Access the Application");

        return "redirect:/";
    }

} catch (Exception e) {

    model.addAttribute(STAR_MESSAGE, e.getMessage());
}

return "registarion/registarion";
}