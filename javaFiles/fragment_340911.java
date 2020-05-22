import javax.xml.bind.*;
import javax.xml.bind.util.JAXBSource;
import javax.xml.transform.Source;
import javax.xml.ws.*;

@ServiceMode(Service.Mode.PAYLOAD)
@WebServiceProvider(
    portName = "FindCustomerPort", 
    serviceName = "FindCustomerService", 
    targetNamespace = "http://service.jaxws.blog/", 
    wsdlLocation = "WEB-INF/wsdl/FindCustomerService.wsdl")
public class FindCustomerService implements Provider<Source> {

    private JAXBContext jaxbContext;

    public FindCustomerService() {
        try {
            jaxbContext = JAXBContext.newInstance(FindCustomerResponse.class,
                    FindCustomerRequest.class);
        } catch (JAXBException e) {
            throw new WebServiceException(e);
        }
    }

    @Override
    public Source invoke(Source request) throws WebServiceException {
        try {
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            FindCustomerRequest fcRequest = (FindCustomerRequest) unmarshaller
                    .unmarshal(request);

            Customer customer = new Customer();
            customer.setId(fcRequest.getArg0());
            customer.setFirstName("Jane");
            customer.setLastName("Doe");

            FindCustomerResponse response = new FindCustomerResponse();
            response.setValue(customer);

            return new JAXBSource(jaxbContext, response);
        } catch (JAXBException e) {
            throw new WebServiceException(e);
        }
    }

}