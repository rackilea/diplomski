public HttpMessageConverter<?> getMappingJackson2HttpMessageConverter() {
    MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter(getJackson2ObjectMapperBuilder().build());
    converter.setSupportedMediaTypes(getSupportedJsonMediaTypes());
    return converter;
}

public HttpMessageConverter<?> getMappingJacksonXmlConverter() {
    MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter(getJacksonXmlObjectMapper());
    converter.setSupportedMediaTypes(getSupportedXmlMediaTypes());
    return converter;
}

private List<MediaType> getSupportedJsonMediaTypes() {
    List<MediaType> mediaTypes = new ArrayList<MediaType>();
    mediaTypes.add(MediaType.APPLICATION_JSON);
    return mediaTypes;
}

private List<MediaType> getSupportedXmlMediaTypes() {
    List<MediaType> mediaTypes = new ArrayList<MediaType>();
    mediaTypes.add(MediaType.APPLICATION_XML);
    return mediaTypes;
}