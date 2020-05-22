public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
    ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
    for (String name : registry.getBeanDefinitionNames()) {
        try {
            BeanDefinition definition = registry.getBeanDefinition(name);
            String beanClassName = defintition.getBeanClassName();

            cls = classLoader.loadClass(beanClassName);

            if(cls.isAnnotationPresent(ExportableService.class)){
                //Get annotation and pull out serviceInterface
                GenericBeanDefinition beanDef = new GenericBeanDefinition();
                beanDef.setBeanClass(HttpInvokerServiceExporter.class);

                MutablePropertyValues values = new MutablePropertyValues();
                values.addPropertyValue("service", new RuntimeBeanReference(name));
                values.addPropertyValue("serviceInterface", "service interface from annotation>);

                beanDef.setPropertyValues(values);

                // Bean name here should be e.g. /myService so its picked up by the BeanNameUrlHandlerMapping (if you so desire)
                registry.registerBeanDefinition(<beanName>, beanDef);
            }
        }
    } catch(ClassNotFoundException e){
        // Handle exception
    }
}