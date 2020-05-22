@Configuration
@EnableAutoConfiguration
//whatever other annotations
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);

        //do whatever
    }

}