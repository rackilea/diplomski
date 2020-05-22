@Bean
    public ResourceBundleMessageSource configureResourceBundleMessageSource() {
    ResourceBundleMessageSource resource = new ResourceBundleMessageSource();
    resource.setBasename("sampleB");
    return resource;
}