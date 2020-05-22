@Configuration
public class BeanDefinitionFactoryTestConfig {

    @Bean
    public MyFactoryPostProcessor cc(){
        return new MyFactoryPostProcessor ();
    }   
}