protected void doProcessProperties(ConfigurableListableBeanFactory beanFactoryToProcess, final StringValueResolver valueResolver) {

    super.doProcessProperties(beanFactoryToProcess,
            new StringValueResolver() {
                @Override
                public String resolveStringValue(String strVal) {
                    return convertPropertyValue(valueResolver.resolveStringValue(strVal));
                }
            }
    );
}