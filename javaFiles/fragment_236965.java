@EnableTransactionManagement
@SpringBootApplication(scanBasePackages = {"com.boot"} , exclude = JpaRepositoriesAutoConfiguration.class)
public class WebApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(WebApplication.class);
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(WebApplication.class, args);
    }
}