public class BeanValidationTest {

    private static ApplicationContext applicationContext; 

    @BeforeClass
    public static void initialize() {
        applicationContext = new ClassPathXmlApplicationContext("classpath:META-INF/spring/webmvc-beans.xml");
        Assert.assertNotNull(applicationContext);
    }

    @Test
    public void test() {
        LocalValidatorFactoryBean factory = applicationContext.getBean("validator", LocalValidatorFactoryBean.class);
        Validator validator = factory.getValidator();
        Person person = new Person();
        person.setLastName("dude");
        Set<ConstraintViolation<Person>> violations = validator.validate(person);
        for(ConstraintViolation<Person> violation : violations) {
            System.out.println("Custom Message:- " + violation.getMessage());
        }
    }

}