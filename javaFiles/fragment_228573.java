@Override
public void postProcessBeanFactory(ConfigurableListableBeanFactory bf)
        throws BeansException {

    String[] beans = bf.getBeanDefinitionNames();
    for (String s : beans) {
        Class<?> beanType = bf.getType(s);
        WebService ws = AnnotationUtils.findAnnotation(beanType,
                WebService.class);
        if (ws != null) {
            String name = getName(s);
            DefaultWsdl11Definition newWS = createWebService(name,
                    ws.xsds());

            bf.registerSingleton(name, newWS);
        }
    }

}