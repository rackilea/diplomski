@SpringBootApplication(scanBasePackages = {"vijay.controller","vijay.configuration"})
public class SpringContextRefreshApplication extends SpringBootServletInitializer{

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(SpringContextRefreshApplication.class); 
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringContextRefreshApplication.class, args);
    }
}