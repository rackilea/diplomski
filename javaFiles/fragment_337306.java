private MappingJackson2HttpMessageConverter customMappingJackson2HttpMessageConverter() {
    MappingJackson2HttpMessageConverter jsonConverter = new MappingJackson2HttpMessageConverter();
    ObjectMapper objectMapper = new ObjectMapper();
    objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
    objectMapper.setDateFormat(new ISO8601DateFormat());
    objectMapper.registerModule(new JavaTimeModule());

    jsonConverter.setObjectMapper(objectMapper);
    return jsonConverter;
}

@Override
public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
    converters.add(customMappingJackson2HttpMessageConverter());
}