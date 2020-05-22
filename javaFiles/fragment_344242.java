private Class<?> getPropertyType(Class<?> clazz, String property) {
    BeanInfo beanInfo = Introspector.getBeanInfo(clazz);
    PropertyDescriptor[] propDescriptors = beanInfo.getPropertyDescriptors();
    for (PropertyDescriptor propDescriptor : propDescriptors) {
        // String name of a property
        if (property.equals(propDescriptor.getName())) {
           // Class the getter corresponds to.
           return propDescriptor.getPropertyType();
        }
    }
    ...
}