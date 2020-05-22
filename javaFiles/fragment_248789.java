@Configuration
@ComponentScan(basePackages = "com.mydomain")
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class AppConfig{

    .....

    @Bean
    public CustomValidatorRegistry validatorRegistry(){
        CustomValidatorRegistry registry = new CustomValidatorRegistry();
        registry.addValidator(new PersonValidator());
        return registry;
    }    
}