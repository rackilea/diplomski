@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        new SpringApplicationBuilder(Application.class)
                .listeners(new LoggingConfigurationApplicationListener())
                .run(args);
    }
}