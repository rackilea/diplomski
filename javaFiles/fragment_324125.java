public class IsIntializedBeanPostProcessor implements BeanPostProcessor {

    private Set<String> initializedBeanNames = new HashSet<String>();

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        initializedBeanNames.add(beanName);
        return bean;
    }

    public Set<String> getInitializedBeanNames() {
        return initializedBeanNames;
    }

}