@RequestMapping(value = "/somepage", method = RequestMethod.GET)
public String somemethod(HttpSession session) throws Exception {
    String abc = null;
    if(someCondition) {
        abc.length();
        return "someview";
    } else {
        // do some stuff here.
        return "someOtherView";
    }
}