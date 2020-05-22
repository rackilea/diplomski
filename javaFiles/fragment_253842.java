@SpringBootApplication
public class BwsApplication {

    private  ConfigClass config;

    public BwsApplication(ConfigClass configClass) {
        config = configClass;//SONAR - Remove this assignment of "config"
    }

    public static void main(String[] args) throws SQLException {
        SpringApplication.run(BwsApplication.class, args);       
    }

    @PostConstruct
    private void postConstruct() {
      Connection con = config.getConnection();
      int number = StudentsManager.getStudentsNumber(con);
      QuartzApp qa = new QuartzApp(config);
      qa.excecution(number);
    }
}