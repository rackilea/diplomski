@Autowired
private Environment environment; 

public Someclass somemethod() {
    Someclass someclass = new Someclass();
    String someField = environment.getProperty("someField");
    someclass.setSomeField(someField);
    return someclass;
}