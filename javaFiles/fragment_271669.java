public class IdFullQualifiedTest extends DefaultHandler2 {
    public final static List<String> NEED_ID = Arrays.asList(new String[] {
            "h:form", "h:inputText", "h:commandButton", "a4j:include",
            "h:dataTable" });

    public void testStructure() throws ParserConfigurationException,
            SAXException, FactoryConfigurationError, IOException {
        Iterator<File> iterateFiles = FileUtils.iterateFiles(new File("src"),
                new String[] { "xhtml" }, true);
        SAXParserFactory f = SAXParserFactory.newInstance();
        SAXParser p = f.newSAXParser();
        while (iterateFiles.hasNext()) {
            p.parse(iterateFiles.next(), this);
        }
    }

    private Locator loc;

    @Override
    public void setDocumentLocator(Locator loc) {
        this.loc = loc;
    }

    @Override
    public InputSource resolveEntity(String name, String publicId,
            String baseURI, String systemId) throws SAXException, IOException {
        return new InputSource(new StringReader(""));
    }

    @Override
    public void startElement(String arg0, String d, String qname,
            Attributes attrs) throws SAXException {
        int idx = NEED_ID.indexOf(qname);
        if (idx >= 0) {
            if (attrs.getIndex("id") < 0) {
                throw new SAXParseException(
                        NEED_ID.get(idx) + " has no id (" + loc.getSystemId()
                                + ":" + loc.getLineNumber() + ") .", loc);
            }
        }
    }
}