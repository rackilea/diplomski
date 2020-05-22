@Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        MappingJackson2HttpMessageConverter jsonConverter = new MappingJackson2HttpMessageConverter();
        StringHttpMessageConverter stringConverter = new StringHttpMessageConverter();
        DynamicMessageConverter dynamicMessageConverter = new DynamicMessageConverter(jsonConverter, stringConverter);
        converters.add(0, dynamicMessageConverter);
    }