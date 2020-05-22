@Configuration
@ComponentScan(basePackages="org.example.customer")
public class SubModuleA1Config {

    @Autowired
    private CustomerFactory customerFactory;

    @Bean
    public SomeBean someBean() {
        return customerFactory.someBean();
   }
}

public interface CustomerFactory {
    SomeBean someBean();
}

@Component
public class C1CustomerFactory implements CustomerFactory {

    @Override
    public SomeBean someBean() {
        return new C1SomeBean();
    }
}