This may helpful...

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        ApplicationContext applicationContext =SpringApplication.run(DemoApplication.class, args);

        Map<String,Object> beans = applicationContext.getBeansWithAnnotation(Controller.class);
        System.out.println(beans.size());
    }

}