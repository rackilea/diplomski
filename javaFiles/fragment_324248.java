@SpringBootApplication
public class DemoApplication {

public static void main(String[] args) {

    ApplicationContext context = SpringApplication.run(DemoApplication.class, args);
     ConfigurationUnit unit = context.getBean("configurationUnit"):

    System.out.print(unit. getConfiList());
   }

}