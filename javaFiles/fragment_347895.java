@SpringBootApplication
public class LoadingApplication extends SpringBootServletInitializer {

public static void main(String[] args) {
    SpringApplication.run(HelloServerApplication.class, args);
}

@Override
protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) 
{
    return builder.sources(HelloServerApplication.class);
}
}