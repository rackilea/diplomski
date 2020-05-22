private Object getPropertyValue(Object bean, String property)
        throws IntrospectionException, IllegalArgumentException,
        IllegalAccessException, InvocationTargetException {
    Class<?> beanClass = bean.getClass();
    PropertyDescriptor propertyDescriptor = getPropertyDescriptor(
            beanClass, property);
    if (propertyDescriptor == null) {
        throw new IllegalArgumentException("No such property " + property
                + " for " + beanClass + " exists");
    }

    Method readMethod = propertyDescriptor.getReadMethod();
    if (readMethod == null) {
        throw new IllegalStateException("No getter available for property "
                + property + " on " + beanClass);
    }
    return readMethod.invoke(bean);
}

private PropertyDescriptor getPropertyDescriptor(Class<?> beanClass,
        String propertyname) throws IntrospectionException {
    BeanInfo beanInfo = Introspector.getBeanInfo(beanClass);
    PropertyDescriptor[] propertyDescriptors = beanInfo
            .getPropertyDescriptors();
    PropertyDescriptor propertyDescriptor = null;
    for (int i = 0; i < propertyDescriptors.length; i++) {
        PropertyDescriptor currentPropertyDescriptor = propertyDescriptors[i];
        if (currentPropertyDescriptor.getName().equals(propertyname)) {
            propertyDescriptor = currentPropertyDescriptor;
        }

    }
    return propertyDescriptor;
}