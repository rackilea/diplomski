class Person {
    private String firstName;
    // other fields, getters, setters
}

public void method(HttpServletRequest httpServletRequest) {
    Person p = new Person();
    p.setFirstName("Obama");
    httpServletRequest.setAttribute("person", p);
}