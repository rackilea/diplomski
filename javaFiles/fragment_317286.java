@Override
public void doWithMessage(WebServiceMessage message) throws IOException, TransformerException
{
    try
    {
        SOAPMessage soapMessage = ((SaajSoapMessage)message).getSaajMessage();
        SOAPHeader header = soapMessage.getSOAPHeader();
        SOAPHeaderElement soapHeaderElement = header.addHeaderElement(new QName("http://www.ups.com/XMLSchema/XOLTWS/UPSS/v1.0", "UPSSecurity", "v1"));
        SOAPEnvelope envelope = soapMessage.getSOAPPart().getEnvelope();
        envelope.addNamespaceDeclaration("v1", "http://www.ups.com/XMLSchema/XOLTWS/UPSS/v1.0");

        SOAPElement usernameToken = soapHeaderElement.addChildElement("UsernameToken", "v1");
        SOAPElement username = usernameToken.addChildElement("Username", "v1");
        SOAPElement password = usernameToken.addChildElement("Password", "v1");

        SOAPElement serviceAccessToken = soapHeaderElement.addChildElement("ServiceAccessToken", "v1");
        SOAPElement accessLicenseNumber = serviceAccessToken.addChildElement("AccessLicenseNumber", "v1");

        username.setTextContent("username");
        password.setTextContent("password");
        accessLicenseNumber.setTextContent("key");
    } 
    catch (SOAPException e)
    {
        e.printStackTrace();
    }
}