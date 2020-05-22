@Stateless
@LocalBean
public class AnyServices{

    @WebServiceRef(wsdlLocation = "META-INF/wsdl/AnyService/Any.wsdl")
    private AnyService service;

    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public String findLastname(Integer key) {
        Any port = service.getAnyPort();
        AnyPerson sp = port.findAnynumber(key);
        return sp.getLastname();
    }

}