public Object doResolveDependency(DependencyDescriptor descriptor, String beanName,
        Set<String> autowiredBeanNames, TypeConverter typeConverter) throws BeansException {

    Class<?> type = descriptor.getDependencyType();
    //Searches for an @Value annotation and 
    Object value = getAutowireCandidateResolver().getSuggestedValue(descriptor);
    if (value != null) {
        //Handle finding, building and returning default value
    }
    /* 
     * Check for multiple beans of given type. Because a bean is returned here,
     * Spring autowires the Integer bean instance.
     */
    Object multipleBeans = resolveMultipleBeans(descriptor, beanName, autowiredBeanNames, typeConverter);
    if (multipleBeans != null) {
        return multipleBeans;
    }
    InjectionPoint previousInjectionPoint = ConstructorResolver.setCurrentInjectionPoint(descriptor);
    try {
        Map<String, Object> matchingBeans = findAutowireCandidates(beanName, type, descriptor);
        // Do more stuff here to try and narrow down to a single instance to autowire.
    }
}