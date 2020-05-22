@SpringBootApplication
public class MainApplication extends SpringBootServletInitializer {

public static void main(String[] args) {
    SpringApplication.run(MainApplication.class, args);
}

@Override
protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
    return application.sources(MainApplication.class);
}
}