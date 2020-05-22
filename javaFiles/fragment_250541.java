protected void injectDependencies(final TestContext testContext) throws Exception {
    Object bean = testContext.getTestInstance();
    AutowireCapableBeanFactory beanFactory = testContext.getApplicationContext().getAutowireCapableBeanFactory();
    beanFactory.autowireBeanProperties(bean, AutowireCapableBeanFactory.AUTOWIRE_NO, false);
    beanFactory.initializeBean(bean, testContext.getTestClass().getName());
    testContext.removeAttribute(REINJECT_DEPENDENCIES_ATTRIBUTE);
}