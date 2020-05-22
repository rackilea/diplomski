@Configuration
@EnableAutoConfiguration
@ComponentScan({"com.my.package.controller","com.my.package.domain"})
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}