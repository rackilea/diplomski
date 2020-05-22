public class LBSController 
{
    private static final String endpoint = "http://iplaypen.globelabs.com.ph:1881/axis2/services/Platform";

public static void main(String[] args) throws SOAPException {
//CREATE SOAP MESSAGE
SOAPMessage message = MessageFactory.newInstance().createMessage();
SOAPHeader header = message.getSOAPHeader();
header.detachNode();

//SOAP SETTINGS
SOAPEnvelope envelope = message.getSOAPPart().getEnvelope();
envelope.setEncodingStyle("http://schemas.xmlsoap.org/soap/encoding/");

SOAPBody body = message.getSOAPBody();
QName bodyName = new QName("getConsent");
SOAPBodyElement bodyElement = body.addBodyElement(bodyName);

//SET CONTENT
SOAPElement uName = bodyElement.addChildElement("uName");
uName.addTextNode("k2r2t1zvc");
SOAPElement uPin = bodyElement.addChildElement("uPin");
uPin.addTextNode("21737629");
SOAPElement MSISDN = bodyElement.addChildElement("MSISDN");
MSISDN.addTextNode("09278328310");

//CREATE CONNECTION
SOAPConnection connection = SOAPConnectionFactory.newInstance().createConnection();
SOAPMessage response = connection.call(message, endpoint);
connection.close();

SOAPBody responseBody = response.getSOAPBody();
SOAPBodyElement responseElement = (SOAPBodyElement)responseBody.getChildElements().next();
SOAPElement returnElement = (SOAPElement)responseElement.getChildElements().next();

if(responseBody.getFault()!=null){
    System.out.println(returnElement.getValue()+" "+responseBody.getFault().getFaultString());
} else {
    System.out.println(returnElement.getValue());
}

//PRINT OUT RAW XML
ByteArrayOutputStream out = new ByteArrayOutputStream();
String xml = "";
try {
    response.writeTo(out);
    xml = out.toString("UTF-8");
} catch (Exception e) 
{
    System.out.println(""+e);
    //log.error(e.getMessage(),e);
}      
System.out.println(""+xml);

/*
try {
    System.out.println(getXmlFromSOAPMessage(message));
    System.out.println(getXmlFromSOAPMessage(response));
} catch (IOException e) {
    e.printStackTrace();
}
* */
}