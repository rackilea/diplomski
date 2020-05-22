@Autowired
JmsTemplate jmsTemplate

...

@Bean
MessageConverter messageConverter() {
    MarshallingMessageConverter converter = new MarshallingMessageConverter()
    converter.marshaller = marshaller()
    converter.unmarshaller = marshaller()
    // set this converter on the implicit Spring JMS template
    jmsTemplate.messageConverter = converter
    converter
}

@Bean
Jaxb2Marshaller marshaller() {
    Jaxb2Marshaller marshaller = new Jaxb2Marshaller()
    marshaller.classesToBeBound = [My.class, MyOther.class]
    marshaller
}