@Configuration
@Import({EJBConfig.class, WebConfig.class})
public class AppConfig {
}

@Configuration
public class EJBConfig {
    @Bean
    public LocalStatelessSessionProxyFactoryBean fooService(){
        LocalStatelessSessionProxyFactoryBean factory = new LocalStatelessSessionProxyFactoryBean();
        factory.setBusinessInterface(FooService.class);
        factory.setJndiName("java:app/model/FooServiceBean!com.company.ejb.FooService");
        return factory;
    }
}

@Configuration
@ComponentScan(basePackages = "com.company.web")
public class WebConfig extends WebMvcConfigurationSupport {
   // basic Spring MVC setup omitted
}