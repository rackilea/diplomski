@InitBinder
public void initBinder(WebDataBinder binder) {
    // You can register your validator for bean Login here
}

@RequestMapping(value = "/log",method = RequestMethod.GET)
public String addPersonLogin(@ModelAttribute Login login, HttpServletRequest request) {
    // To make it work your form fields should have names equals to bean fields names
    login.getUserName();
    login.getPassword();
}