@Bean
public RestTemplate yourRestTemplate(RestTemplateBuilder builder) {
    Jaxb2RootElementHttpMessageConverter converter = new Jaxb2RootElementHttpMessageConverter();
    converter.setSupportDtd(true);

    return builder.messageConverters(converter).build()
}