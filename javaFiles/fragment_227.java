@Configuration
class WebConfig extends WebMvcConfigurerAdapter {

    private final static void
            addDefaultHttpMessageConverters(final List<HttpMessageConverter<?>> messageConverters) {
        final StringHttpMessageConverter stringConverter = new StringHttpMessageConverter();
        stringConverter.setWriteAcceptCharset(false);
        messageConverters.add(new ByteArrayHttpMessageConverter());
        messageConverters.add(stringConverter);
        messageConverters.add(new ResourceHttpMessageConverter());
        messageConverters.add(new SourceHttpMessageConverter<>());
        messageConverters.add(new AllEncompassingFormHttpMessageConverter());
    }

    @Override
    public void configureMessageConverters(final List<HttpMessageConverter<?>> converters) {
        converters.add(mappingJackson2HttpMessageConverter(feederObjectMapper()));
        addDefaultHttpMessageConverters(converters);