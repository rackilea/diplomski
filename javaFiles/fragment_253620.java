//create module
JaxbAnnotationModule jaxbAnnotationModule = new JaxbAnnotationModule();

restTemplate.getMessageConverters().stream().filter(converter -> {
    return converter instanceof MappingJackson2XmlHttpMessageConverter;
})