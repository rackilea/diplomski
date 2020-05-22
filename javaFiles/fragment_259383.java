private static final String XMLNS_WSU = "http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd";
private static final String XSD_WSSE = "http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd";

final List<Header> headers = new ArrayList<Header>();
final SOAPFactory sf = SOAPFactory.newInstance();
final SOAPElement securityElement = sf.createElement("Security", "wsse", XSD_WSSE);
final SOAPElement authElement = sf.createElement("BinarySecurityToken", "wsse", XSD_WSSE);
authElement.setAttribute("ValueType", "WASP");
authElement.setAttribute("EncodingType", "wsse:Base64Binary");
authElement.setAttribute("wsu:Id", "SecurityToken");
authElement.addAttribute(new QName("xmlns:wsu"), XMLNS_WSU);
authElement.addTextNode(StringUtils.replace(SessionToken.getEncodedSessionToken(), "\n", ""));
securityElement.addChildElement(authElement);
final SoapHeader securityHeader = new SoapHeader(
        new QName(null, "Security"), securityElement);
headers.add(securityHeader);
((BindingProvider) interactiveService).getRequestContext().put(Header.HEADER_LIST, headers);