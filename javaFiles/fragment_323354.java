@SpringBootApplication
public class TrackerApplication extends SpringBootServletInitializer{

public static void main(String[] args) {
    SpringApplication.run(TrackerApplication.class, args);
}

@Override
protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
    return builder.sources(TrackerApplication.class);
}

}