XPathFactory xPathfactory = XPathFactory.newInstance();
XPath xpath = xPathfactory.newXPath();
xpath.setNamespaceContext(new NamespaceContext() {
    @Override
    public String getNamespaceURI(String prefix) {
        if (prefix.equals("soap")) {
            return "http://www.w3.org/2003/05/soap-envelope";
        }
        if (prefix.equals("zmb")) {
            return "urn:zimbra";
        }

        return XMLConstants.NULL_NS_URI;
    }

    @Override
    public String getPrefix(String namespaceURI) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Iterator getPrefixes(String namespaceURI) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
});

XPathExpression expr = 
       xpath.compile("/soap:Envelope/soap:Header/zmb:context/zmb:session");
String sessionId = (String)expr.evaluate(doc, XPathConstants.STRING);