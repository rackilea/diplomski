/* using fully qualified class names as default bean names */
 private BeanNameGenerator importBeanNameGenerator = new   AnnotationBeanNameGenerator() {
    @Override
    protected String buildDefaultBeanName(BeanDefinition definition) {
        return definition.getBeanClassName();
    }
};