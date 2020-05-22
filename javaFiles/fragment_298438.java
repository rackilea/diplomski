public void setA() throws IOException {
    EncodedResource encodedResource = new EncodedResource(new ClassPathResource("MessageMappingA.properties"));
    ResourcePropertySource resourcePropertySource = new ResourcePropertySource(encodedResource);

    MutablePropertySources propertySources = this.environment.getPropertySources();
    propertySources.addFirst(resourcePropertySource);
}