@ComponentScan
@EnableAutoConfiguration
@ImportResource("application-context.xml")
public class Application {
   public static void main(final String[] args) {
        SpringApplication.run(Application.class, args);
   }
}