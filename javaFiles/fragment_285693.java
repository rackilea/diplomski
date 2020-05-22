@SpringBootApplication
@RestController
@ComponentScan({“package.name.1”,”package.name.2”})
public class HelloWorldRestApplication {

public static void main(String[] args) {
    ApplicationContext ctx = SpringApplication.run(HelloWorldRestApplication.class, args);

    Performer p = ctx.getBean(Performer.class);//get the bean by type                      
    p.perform();
    }
}