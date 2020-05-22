@Component
public class HeaderPropagationInterceptor implements ClientInterceptor
{
    private JAXBContext jaxbContext;

    @PostConstruct
    public void createJaxbContext() {
        try {
            jaxbContext = JAXBContext.newInstance(RequestHeader.class);
        }
        catch(JAXBException e) {
            throw new IllegalStateException("Unable to create JAXBContext.", e);
        }
    }

    @Override
    public boolean handleRequest(MessageContext messageContext) throws WebServiceClientException {
        SoapMessage request = (SoapMessage) messageContext.getRequest();
        Result result = request.getSoapHeader().getResult();
        jaxbContext.createMarshaller().marshal(getRequestHeader(), result);
        return true;
    }
}