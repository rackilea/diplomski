@Configuration
@EnableAutoConfiguration
@ComponentScan
public class Application {


    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);
    }

}