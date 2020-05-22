@Bean
public Jaxb2RootElementHttpMessageConverter jaxb2RootElementHttpMessageConverter() {
    Jaxb2RootElementHttpMessageConverter converter = new Jaxb2RootElementHttpMessageConverter();
    converter.setSupportDtd(true);
    return converter;
}