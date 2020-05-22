@Bean
public MarshallingHttpMessageConverter marshallingMessageConverter() {
    return new MarshallingHttpMessageConverter(
        jaxb2Marshaller(),
        jaxb2Marshaller()
    );
}

@Bean
public Jaxb2Marshaller jaxb2Marshaller() {
    Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
    marshaller.setClassesToBeBound(new Class[]{
               twitter.model.Statuses.class
    });
    return marshaller;
}