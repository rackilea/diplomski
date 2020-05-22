@Configuration
public class MyServiceConfig {
    @Bean
    public MyService serviceA(@Qualifier("beanA") beanA) {
        return new MyService(beanA);
    }

    @Bean
    public MyService serviceB(@Qualifier("beanB") beanB) {
        return new MyService(beanB);
    }
}