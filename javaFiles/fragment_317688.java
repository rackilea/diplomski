@Override
protected void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
    for (Iterator<HttpMessageConverter<?>> iterator = converters.iterator(); iterator.hasNext(); ) {
        HttpMessageConverter<?> converter = iterator.next();
        if (converter instanceof Jaxb2RootElementHttpMessageConverter) {
            iterator.remove();
        }
    }

    ObjectMapper objectMapper = Jackson2ObjectMapperBuilder.xml().applicationContext(this.getApplicationContext()).build();
    converters.add(new MappingJackson2XmlHttpMessageConverter(objectMapper));
}