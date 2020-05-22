public class MyCustomEndpointInterceptor implements SmartSoapEndpointInterceptor {

    @Override
    public boolean handleRequest(MessageContext messageContext, Object endpoint) throws Exception {
        return true;
    }

    @Override
    public boolean handleResponse(MessageContext messageContext, Object endpoint) throws Exception {
        SaajSoapMessage soapResponse = (SaajSoapMessage) messageContext.getResponse();
        DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(strMsg);
        Document doc = soapResponse.getDocument();
        // Look for the SOAP header
        Element headerElement = null;
        NodeList nodes = doc.getElementsByTagNameNS("http://schemas.xmlsoap.org/soap/envelope/", "Header");
        if (nodes.getLength() == 0) {
            System.out.println("Adding a SOAP Header Element");
            headerElement = doc.createElementNS("http://schemas.xmlsoap.org/soap/envelope/", "Header");
            nodes = doc.getElementsByTagNameNS("http://schemas.xmlsoap.org/soap/envelope/", "Envelope");
            if (nodes != null) {
                Element envelopeElement = (Element) nodes.item(0);
                headerElement.setPrefix(envelopeElement.getPrefix());
                envelopeElement.appendChild(headerElement);
            }
        } else {
            System.out.println("Found " + nodes.getLength() + " SOAP Header elements.");
            headerElement = (Element) nodes.item(0);
        }

        Provider kncaProvider = new IolaProvider();
        Security.addProvider(kncaProvider);

        KeyStore ks = KeyStore.getInstance("pkcs12", kncaProvider.getName());

        ks.load(new FileInputStream(keypath), keypass.toCharArray());

        PrivateKey privateKey = (PrivateKey) ks.getKey(keyalias, keypass.toCharArray());

        XMLSignature sig = new XMLSignature(doc, "", "http://www.w3.org/2001/04/xmldsig-more#gost34310-gost34311");
        headerElement.appendChild(sig.getElement());
        Transforms transforms = new Transforms(doc); 
        transforms.addTransform("http://www.w3.org/2000/09/xmldsig#enveloped-signature");
        transforms.addTransform("http://www.w3.org/TR/2001/REC-xml-c14n-20010315#WithComments");
        sig.addDocument("", transforms,"http://www.w3.org/2001/04/xmldsig-more#gost34311"); 
        X509Certificate cert = (X509Certificate) ks.getCertificate(somealias);
        sig.addKeyInfo(cert); 
        sig.sign(privateKey);

        return true;
    }

    @Override
    public boolean handleFault(MessageContext messageContext, Object endpoint) throws Exception {
        return true;
    }

    @Override
    public boolean shouldIntercept(MessageContext messageContext, Object endpoint) {
        return true;
    }

    @Override
    public boolean understands(SoapHeaderElement header) {
        return true;
    }
}