@Configuration
public class ApplicationContext {
    @Bean
    public CastorMarshaller castorMarshaller() {
        return new CastorMarshaller();
    }

    @Bean
    public XMLConverter XMLConverter() {
        XMLConverter convertor = new XMLConverter();
        CastorMarshaller marshaller = castorMarshaller();
        convertor.setMarshaller(marshaller);
        convertor.setUnmarshaller(marshaller);
    }
}