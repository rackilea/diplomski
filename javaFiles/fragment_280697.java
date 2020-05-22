@RequestMapping(value="/{registration_path}",method=RequestMethod.POST)
public String register(@Validated(RegistrationGroup.class) kisitablo kisitablo, BindingResult result.....) {
        if (result.hasErrors()) {
            return "login";
        }
        //Your logic.....
    }