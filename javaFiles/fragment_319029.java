@Bean
    public ResourceBundleMessageSource configureResourceBundleMessageSource() {
    ResourceBundleMessageSource resource = new ResourceBundleMessageSource();
    resource.setBasename("sampleA");
    return resource;
}