public class Config {

    public static void main(String[] args) throws Exception {

        ApplicationContext desiredContext1 = new ClassPathXmlApplicationContext("file:////...path.../context1.xml");
        String[] congigPath = new String[1];
        congigPath[0] = "file:////...path.../context2.xml";
        ApplicationContext desiredContext2 = new ClassPathXmlApplicationContext(congigPath,desiredContext1);
    }
}