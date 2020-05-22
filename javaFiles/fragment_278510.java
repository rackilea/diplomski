public Object postProcessBeforeInitialization(Object bean, String beanName)
        throws BeansException {
    System.out.println("postProcessBeforeInitialization for bean "+beanName);

    return this;
}