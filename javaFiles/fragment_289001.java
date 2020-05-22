public class WSSESecurityHeaderRequestWebServiceMessageCallback implements WebServiceMessageCallback {

    public void doWithMessage(WebServiceMessage message) throws IOException, TransformerException {

        try {

            // Assumption: We are using the default SAAJWebMessageFactory 

            SaajSoapMessage
                saajSoapMessage =
                    (SaajSoapMessage)message;

            SOAPMessage
                soapMessage =
                    saajSoapMessage.getSaajMessage();

            SOAPPart
                soapPart =
                    soapMessage.getSOAPPart();

            SOAPEnvelope
                soapEnvelope =
                    soapPart.getEnvelope();

            SOAPHeader
                soapHeader =
                    soapEnvelope.getHeader();

            Name
                headerElementName =
                    soapEnvelope.createName(
                        "Security",
                        "wsse",
                        "http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd"
                    );

            // Add "Security" soapHeaderElement to soapHeader
            SOAPHeaderElement
                soapHeaderElement =
                    soapHeader.addHeaderElement(headerElementName);

            // This may be important for some portals!
            soapHeaderElement.setActor(null);

            // Add usernameToken to "Security" soapHeaderElement 
            SOAPElement
                usernameTokenSOAPElement =
                    soapHeaderElement.addChildElement("UsernameToken");

            // Add username to usernameToken
            SOAPElement
                userNameSOAPElement =
                    usernameTokenSOAPElement.addChildElement("Username");

            userNameSOAPElement.addTextNode("myUserName");

            // Add password to usernameToken
            SOAPElement
                passwordSOAPElement =
                    usernameTokenSOAPElement.addChildElement("Password");

            passwordSOAPElement.addTextNode("myPassword");

        } catch (SOAPException soapException) {
            throw new RuntimeException("WSSESecurityHeaderRequestWebServiceMessageCallback", soapException);
        }
    }
}