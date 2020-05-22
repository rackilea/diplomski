public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
    ObjectMapper mapper = new ObjectMapper();
    // ...initialize...

    for (HttpMessageConverter<?> converter : converters) {
        if (converter instanceof MappingJackson2HttpMessageConverter) {
            MappingJackson2HttpMessageConverter m = (MappingJacksonHttpMessageConverter) converter;
            m.setObjectMapper(mapper);
        }
    } 
}