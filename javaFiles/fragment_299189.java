@SpringBootApplication
public class DemoSimpleApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(DemoSimpleApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(DemoSimpleApplication.class, args);
    }

}