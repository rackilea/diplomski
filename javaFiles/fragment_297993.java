public class HeaderHandler implements SOAPHandler<SOAPMessageContext> {

public boolean handleMessage(SOAPMessageContext smc) {
    System.out.println("URL of Endpoint" +smc.get(JAXWSProperties.HTTP_REQUEST_URL));
 }
}