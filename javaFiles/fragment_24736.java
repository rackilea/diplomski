@Configuration
public class AppConfig {
    @Bean
    @Autowired
    public SomeBean BeanSomeBean() {
        return new SomeBean();
    }

    @Bean
    @Autowired
    public AnyOtherClass BeanAnyOtherClass() {
        return new AnyOtherClass();
    }
}