public void test(){
    childContext = new AnnotationConfigApplicationContext();
    childContext.setParent(parentContext);
    register(TestConfig2.class);
    configurer = parentContext.getBean(PropertyPlaceholderConfigurer.class);
    childContext.addBeanFactoryPostProcessor(configurer);
    childContext.refresh();

    MessageListener messageListener = childContext.getBean(MessageListener.class);
    parentContext.addApplicationListener(messageListener);

    // some testing stuff here that generates events
}