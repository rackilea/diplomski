List<Object> beanRefrences = new ManagedList<>();
for(String attribute : attributes) {
    Object beanReference = new RuntimeBeanReference(attribute);
    beanRefrences.add(beanReference);
}
mutablePropertyValues.add(propertyName, beanRefrences);