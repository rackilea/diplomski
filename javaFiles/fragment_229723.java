SoapMessage soapMessage = (SoapMessage) message;
SOAPMessage doc = getSOAPMessage(soapMessage);

Element elem = WSSecurityUtil.getSecurityHeader(doc.getSOAPPart(), "");
// get a BinarySignature tag
Node binarySignatureTag = elem.getFirstChild();
BinarySecurity token = new X509Security((Element) binarySignatureTag);

// a X509Certificate construction
InputStream in = new ByteArrayInputStream(token.getToken());
CertificateFactory certFactory = CertificateFactory.getInstance("X.509");
X509Certificate cert = (X509Certificate)certFactory.generateCertificate(in);