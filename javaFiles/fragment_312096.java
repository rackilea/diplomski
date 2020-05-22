public class App {
    public static void main(String[] args) throws Exception {

        ApplicationContext appContext = new ClassPathXmlApplicationContext("appcontext.xml");

        //-------------------------
        AopClass aopClass = (AopClass) appContext.getBean("AopClass");
        aopClass.addCustomerAround("dummy");
    }
}