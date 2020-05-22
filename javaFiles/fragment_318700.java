@Configuration
@EnableAutoConfiguration
@ComponentScan(basePackageClasses = {SomeService.class, SomeData.class})
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}