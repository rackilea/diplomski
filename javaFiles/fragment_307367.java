public class TestPersist {
    @org.testng.annotations.Test
    public void testPersistence() throws Exception {

        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-context.xml");
        Assert.assertNotNull(ctx);

        UsersService userService = ctx.getBean(UsersService.class);

        Assert.assertNotNull(userService);
        UsersEntity user2 = new UsersEntity();
        user2.setEnable(true);
        user2.setLogin("querty");
        user2.setName("user2");

        userService.addUser(user2);

    }
}