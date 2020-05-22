@Provider
@Consumes(MediaType.APPLICATION_XML)
public class AddressXmlValidationReader extends
        AbstractXmlValidationReader<Address> {

    private final static String xsdFileName = "/xsd/Address.xsd";

    public AddressXmlValidationReader(@Context Providers providers,
            @Context ServletContext servletContext) {
        super(providers, servletContext, xsdFileName);
    }
}