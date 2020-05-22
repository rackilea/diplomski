@RequestMapping(value = "save_user", method = RequestMethod.POST)
@ResponseBody
public String saveUser(@Valid User user, BindingResult result) {
        if(result.hasErrors()) {
            return "common/add_user"; // Here I need to return the view name or do redirect
        } else {
            userManager.add(user);
            return "success... bla bla bla"; // Here I need to return some message.
        }
}