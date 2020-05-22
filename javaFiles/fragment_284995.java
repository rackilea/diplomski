public class MainApp {


        public static ApplicationContext applicationContext;

        private static IPersonelService personelService;


        public static void main(String[] args) {

            applicationContext = new ClassPathXmlApplicationContext("hibernate-config.xml");
            personelService = applicationContext.getBean(IPersonelService.class);

            Personel p = new Personel();
            p.setName("thatsOK!");
            p.setAge("614345");

            personelService.savePersonel(p);

        }
    }