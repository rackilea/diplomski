@Configuration
@EnableWebMvc //THIS
@ComponentScan(basePackages = "guru.services")

public  class InterfaceImpl implements Services{

@Autowired
TestRepository test;
Test entity;

// ADD GETTERS AND SETTERS OF test

public InterfaceImpl() {
super();
}
// ALL METHODS HERE
}