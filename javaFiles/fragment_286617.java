@Component
public class FindBeanConfigLocation implements BeanDefinitionRegistryPostProcessor {

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory arg0) throws BeansException {
    }

    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
        BeanDefinition javaConfigBeanDefinition = registry.getBeanDefinition("a");
        System.out.println("Creation class for a=" + javaConfigBeanDefinition.getResourceDescription());

        BeanDefinition xmlBeanDefinition = registry.getBeanDefinition("xmlBean");
        System.out.println("Creation XML file for xmlBean=" + xmlBeanDefinition.getResourceDescription());
    }

}