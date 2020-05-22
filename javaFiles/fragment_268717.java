@RequestMapping(method = RequestMethod.POST)
public ModelAndView create(@Valid UserCreateCommand userCreateCommand,
                           BindingResult bindingResult) {
   if (bindingResult.hasErrors()) {
        //or some of your handling for bindingResult errors
        return new ModelAndView("user/create", userCreateCommand", userCreateCommand);
    } else {
    ...
    }
}