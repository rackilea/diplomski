public class ModifySoapHeaderInterceptor implements
    SmartEndpointInterceptor 
{
  //WSConstants.WSSE_NS;
   private static final String DEFAULT_SECURITY_URL = "http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd";
    private static final String SECURITY_TAG = "Security";
    private static final String SECURITY_PREFIX = "wsse";
    private static final String USER_NAME_TOKEN = "UsernameToken";

    @Override
public boolean handleRequest(MessageContext messageContext, Object endpoint)
        throws Exception 
{
      SaajSoapMessage saajSoapMessage(SaajSoapMessage)messageContext.getRequest());
      SOAPHeader soapHeader = saajSoapMessage.getSaajMessage().getSOAPPart()
            .getEnvelope().getHeader();

       //you can modify header's as you choose
       Name headerElement = saajSoapMessage.getSaajMessage().getSOAPPart()
            .getEnvelope()
            .createName(SECURITY_TAG, SECURITY_PREFIX, DEFAULT_SECURITY_URL);
       SOAPHeaderElement soapHeaderElement = soapHeader
            .addHeaderElement(headerElement);
    SOAPElement usernameToken = soapHeaderElement.addChildElement(
            USER_NAME_TOKEN, SECURITY_PREFIX);

    SOAPElement userNameElement = usernameToken.addChildElement("Username",
            SECURITY_PREFIX);
    userNameElement.addTextNode("userid");//you can inject via spring

    SOAPElement passwordElement = usernameToken.addChildElement("Password",
            SECURITY_PREFIX);
    passwordElement.addTextNode("password");
       return true;
    }
}