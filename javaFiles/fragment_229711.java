public class SpringHelloWorldTest {
    public static void main(String[] args) {
        ApplicationContext context= new ClassPathXmlApplicationContext("SpringHelloWorld.xml");
        Spring3HelloWorld myBean= (Spring3HelloWorld) context.getBean("Spring3HelloWorldBean");
        myBean.sayHello();
    }
}