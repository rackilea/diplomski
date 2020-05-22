@SpringBootApplication
public class Application {

    @Value("{property:}")
    protected String property;

    public static void main(String[] args) throws IOException {
        ConfigurableApplicationContext context = SpringApplication.run(AccountApiApplication.class, args);
        AccountApiApplication app = context.getBean(AccountApiApplication.class);
        app.doMyTask(context);
    }

    public void doMyTask(ConfigurableApplicationContext context)  {
      if(property) {
          context.close();
      }
      else {
        // do something else
      }

    }
}