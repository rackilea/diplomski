@Configuration
public class SubModuleA1Config {

@Autowired
private Environment env;

@Bean
public SomeBean someBean() {
      String customerProperty = env.getProperty("customer");
      if ("C1".equals(customerProperty))  
        return new C1SomeBean();

      return new SomeBean(); 

   }
}