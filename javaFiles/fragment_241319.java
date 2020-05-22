public class Config {

    public static void main(String[] args) throws Exception {

        ApplicationContext desiredContext1 = new ClassPathXmlApplicationContext("file:////...path.../context1.xml");

        ApplicationContext desiredContext2 = new ClassPathXmlApplicationContext("file:////...path.../context2.xml");
    }
}