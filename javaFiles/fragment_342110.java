@SpringBootApplication
@ComponentScan(basePackages="ApiServer")
public class Application  {
    public static void main(String[] args) throws Exception {
        ApplicationContext ctx = SpringApplication.run(Application.class, args);
        String[] beanNames = ctx.getBeanDefinitionNames();
        Arrays.sort(beanNames);
        for (String beanName : beanNames) {
            System.out.println("BEAN :: " + beanName);
        }
    }