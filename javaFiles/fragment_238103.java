public class abcde {

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("META-INF/spring/application-context.xml");
        UserService u = ctx.getBean("userService");
        u.insert();

    }
}