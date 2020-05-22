XPath xpath = XPathFactory.newInstance().newXPath();
xpath.setNamespaceContext(new NamespaceContext() {

    @Override
    public Iterator getPrefixes(String namespaceURI) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String getPrefix(String namespaceURI) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String getNamespaceURI(String prefix) {
        if ("soap".equals(prefix)) {
            return "http://www.w3.org/2003/05/soap-envelope";
        }
        return null;
    }
});

String expression = "/soap:Envelope/soap:Body";
Node node = (Node) xpath.compile(expression).evaluate(doc, XPathConstants.NODE);
node.setTextContent("Body was removed");