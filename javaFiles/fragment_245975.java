public class SOAPAuthenticationHandler implements SOAPHandler<SOAPMessageContext> {

    private String username;
    private String password;

    public SOAPAuthenticationHandler (String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public boolean handleMessage(SOAPMessageContext smc) {
        Boolean outboundProperty = (Boolean) smc.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY);
        if (!outboundProperty) {
            return outboundProperty;
        }
        try {
            SOAPEnvelope envelope = smc.getMessage().getSOAPPart().getEnvelope();
            SOAPHeader header = envelope.addHeader();
            SOAPElement security = header.addChildElement("Security", "wsse", "http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd");
            security.addNamespaceDeclaration("common", "some xmlns");
            SOAPElement usernameToken = security.addChildElement("UsernameToken", "wsse");
            usernameToken.addAttribute(new QName("xmlns:wsu"), "http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd");
            SOAPElement usernameElement = usernameToken.addChildElement("Username", "wsse");
            usernameElement.addTextNode(username);
            SOAPElement passwordElement = usernameToken.addChildElement("PasswordSaltedDigest", "common");
            passwordElement.setAttribute("Type", "http://www.w3.org/2001/04/xmldsig-more#gostr341194");
            passwordElement.addTextNode(password);
        } catch (SOAPException | DOMException e) {
            getLogger().error(e.getMessage());
        }
        return outboundProperty;
    }

    @Override
    public boolean handleFault(SOAPMessageContext context) {
        return false;
    }

    @Override
    public void close(MessageContext context) {
    }

    @Override
    public Set<QName> getHeaders() {
        return null;
    }
}