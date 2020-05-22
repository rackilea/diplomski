public class PersonBeanTest {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        assertNotNull(context.getBean(PersonBean.class));
    }

}