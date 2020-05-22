@ContextConfiguration (locations = {"classpath:spring-test-config.xml"})
public class TestSpring extends LocalSpringBase {

    @Autowired
    EmailGenerator emailGenerator;

    @Test ()
    void testEmailGenerator() {
        String email = emailGenerator.generate();
        System.out.println(email);

        Assert.assertNotNull(email);
        Assert.assertEquals(email, "feedback@yoursite.com");
    }

}