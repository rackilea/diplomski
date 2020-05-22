@ModelAttribute("foo")
public Foo getFoo(HttpServletRequest request) {
    Foo foo = new Foo();
    foo.setIp(request.getRemoteAddr());
    return foo;
}

@InitBinder("foo")
public void initBinder(WebDataBinder binder) {
    binder.setDisallowedFields("ip"); // Don't allow user to override the value
}