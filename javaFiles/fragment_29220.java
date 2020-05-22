@SpringBootApplication
@EnableJpaRepositories
@ComponentScan("com.lopamoko")
public class CloudliquidApplication {

public static void main(String[] args) {
    ApplicationContext ctx = SpringApplication.run(CloudliquidApplication.class, args);

    String[] beanNames = ctx.getBeanDefinitionNames();
    Arrays.sort(beanNames);
    for (String beanName : beanNames) {
        System.out.println(beanName);
    }
}