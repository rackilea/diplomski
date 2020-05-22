@RequestMapping(value = "/addUser", method = RequestMethod.POST)
public String addUser(@Valid User user, BindingResult result) {

        if (result.hasErrors()) {
            return "errorPage";
        } else {
            return "Done";
        }
    }