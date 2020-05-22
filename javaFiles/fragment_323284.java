@Configuration
public class MyFactoryPostProcessor implements BeanDefinitionRegistryPostProcessor, PriorityOrdered{

    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
        BeanDefinition someConfig= new RootBeanDefinition("x.y.z.SomeConfig");
        registry.registerBeanDefinition("someConfig", enableOAuth2ClientBd);
    }

    @Override
    public int getOrder() {
        return Ordered.HIGHEST_PRECEDENCE;
    }
}