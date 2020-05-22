// To handle the case of an inter-bean method reference, we must explicitly check the
// container for already cached instances.

// First, check to see if the requested bean is a FactoryBean. If so, create a subclass
// proxy that intercepts calls to getObject() and returns any cached bean instance.
// This ensures that the semantics of calling a FactoryBean from within @Bean methods
// is the same as that of referring to a FactoryBean within XML. See SPR-6602.
if (factoryContainsBean(BeanFactory.FACTORY_BEAN_PREFIX + beanName) && factoryContainsBean(beanName)) {
    Object factoryBean = this.beanFactory.getBean(BeanFactory.FACTORY_BEAN_PREFIX + beanName);
    if (factoryBean instanceof ScopedProxyFactoryBean) {
        // Pass through - scoped proxy factory beans are a special case and should not
        // be further proxied
    }
    else {
        // It is a candidate FactoryBean - go ahead with enhancement
        return enhanceFactoryBean(factoryBean.getClass(), beanName);
    }
}