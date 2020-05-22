@ComponentScan
@EnableAutoConfiguration
public class Application {

    public static void main(String[] args) {
        ApplicationContext context= SpringApplication.run(Application.class, args);
        CustomerRepository repository = context.getBean(CustomerRepository.class);
        //...
    }
}