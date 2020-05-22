public class EnvironmentTests {

    @Test
    public void addPropertiesToEnvironmentTest() {

        ApplicationContext context = new ClassPathXmlApplicationContext(
                "testContext.xml");

        Environment environment = context.getEnvironment();

        String world = environment.getProperty("hello");

        assertNotNull(world);

        assertEquals("world", world);

        System.out.println("Hello " + world);

    }

}