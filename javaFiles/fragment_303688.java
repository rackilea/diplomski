public class Main {
    public static void main(String[] args) {
        Service service = new ClassPathXmlApplicationContext("context.xml").getBean("someSpecificService", Service.class);
        System.out.println("Service execution status [" + service.run() + "]");
    }
}