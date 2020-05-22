NamespaceContext nsContext = new NamespaceContext() {
    @Override
    public Iterator getPrefixes(String namespaceURI) {
        return null;
    }
    @Override
    public String getPrefix(String namespaceURI) {
        return "soap";
    }
    @Override
    public String getNamespaceURI(String prefix) {
        return "http://schemas.xmlsoap.org/soap/envelope/";
    }
};
xPath.setNamespaceContext(nsContext);