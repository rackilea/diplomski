@Configuration
public class MySoapClientConfiguration {

    private static final JAXBContextFactory jaxbFactory = new JAXBContextFactory.Builder()
       .withMarshallerJAXBEncoding("UTF-8")
       .withMarshallerSchemaLocation("http://apihost http://apihost/schema.xsd")
       .build();

    @Bean
    public Encoder feignEncoder() {
        return new SOAPEncoder(jaxbFactory);
    }
    @Bean
    public Decoder feignDecoder() {
        return new SOAPDecoder(jaxbFactory);
    }
}