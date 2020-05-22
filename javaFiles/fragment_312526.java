private static final XMLOutputProcessor noNamespaces = new AbstractXMLOutputProcessor() {

    @Override
    protected void printNamespace(final Writer out, final FormatStack fstack, 
        final Namespace ns)  throws IOException {
        // do nothing with printing Namespaces....
    }

};