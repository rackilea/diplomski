public class ContextAdder implements BeanFactoryPostProcessor {

@Override
public void postProcessBeanFactory(ConfigurableListableBeanFactory factory)
        throws BeansException {

    XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader((BeanDefinitionRegistry)factory);

    // I)  LOAD BY PATTERN MATCHING
    //PathMatchingResourcePatternResolver resourceResolver = new PathMatchingResourcePatternResolver(factory.getBeanClassLoader());
    //for (Resource resource : resourceResolver.getResources("com/.../*.xml"))
    //reader.loadBeanDefinitions(resource);

    // II)  LOAD A SINGLE FILE AT A TIME
    reader.loadBeanDefinitions(new ClassPathResource("com/../Optimus.xml""));
    .....
}