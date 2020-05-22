public class DependsOnPostProcessor implements BeanFactoryPostProcessor {

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        String[] beanNames = BeanFactoryUtils.beanNamesForTypeIncludingAncestors(
                beanFactory, B.class, true, false);
        for (String beanName : beanNames) {
            BeanDefinition definition = beanFactory.getBeanDefinition(beanName);
            definition.setDependsOn(StringUtils.addStringToArray(
                    definition.getDependsOn(), "beanNameOfB");
        }
    }

}