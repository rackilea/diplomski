// your method that prints the form
public ModelAndView onGet(@ModelAttribute Login login) {
    // return ...
}

@RequestMapping(value="login.htm")
public ModelAndView onSubmit(@ModelAttribute Login login) {
    String userName = login.getUserName();
    String password = login.getPassword();
    // ...
}