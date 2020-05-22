xpath.setNamespaceContext(new NamespaceContext() {
    @Override
    public Iterator getPrefixes(String arg0) {
        return null;
    }

    @Override
    public String getPrefix(String arg0) {
        return null;
    }

    @Override
    public String getNamespaceURI(String arg0) {
        if("w".equals(arg0)) {
            return "YOUR-NAMESPACE";
        }
        return null;
    }
});