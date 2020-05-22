@Configuration
public class MyConfig {

    @Autowired
    private ApplicationContext context;

    @Bean
    public SomeInterface someInterface() {
        if (this.context.getEnvironment().getProperty("implementation") != null) {
            return new ImplementationOne();
        } else {
            return new ImplementationTwo();
        }
    }
}