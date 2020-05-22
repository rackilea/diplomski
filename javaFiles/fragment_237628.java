private ApplicationContext createSpringContext() {
    ApplicationHandler applicationHandler = locator.getService(ApplicationHandler.class);
    ApplicationContext springContext = (ApplicationContext) applicationHandler.getConfiguration().getProperty(PARAM_SPRING_CONTEXT);
    if (springContext == null) {
        String contextConfigLocation = (String) applicationHandler.getConfiguration().getProperty(PARAM_CONTEXT_CONFIG_LOCATION);
        springContext = createXmlSpringConfiguration(contextConfigLocation);
    }
    return springContext;
}