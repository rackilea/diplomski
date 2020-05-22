@RequestMapping(value = "user/{id}", method = RequestMethod.GET)
@ResponseBody
public User get(@PathVariable Long id, Locale locale, Model model) throws NotFoundException {   
    User u = userService.find(id);
    if (u != null)
        return u;
    else
        throw new NotFoundException("user not found");
}

@RequestMapping(value = "user", method = RequestMethod.GET)
@ResponseBody
public List<User> list(Locale locale, Model model) {
    List<User> l = userService.list();  
    return l;
}