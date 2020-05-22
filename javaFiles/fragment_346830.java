@Bean(name = "jaxb2Marshaller")
public JaxbIntroductionsMarshaller jaxb2Marshaller() throws SAXException {
    JaxbIntroductionsMarshaller marshaller = new JaxbIntroductionsMarshaller ();

    marshaller.setClassesToBeBound(new Class[] {
            Person.class,
            WebServiceResponse.class
        });

    Map<String,Object> jaxbContextProperties = new HashMap<String,Object>();
    jaxbContextProperties.put(JAXBRIContext.ANNOTATION_READER, introductionsAnnotationReader());
    marshaller.setJaxbContextProperties(jaxbContextProperties);

    Resource schema = new ClassPathResource("schemas/avs-pdf-query-request.xsd");
    marshaller.setSchema(schema);

    return marshaller;
}

@Bean
public IntroductionsAnnotationReader introductionsAnnotationReader() {
    return new IntroductionsAnnotationReader(parseConfig());
}