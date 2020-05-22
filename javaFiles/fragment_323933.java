Handler handler = new org.xml.sax.helpers.DefaultHandler {
    @Override
    public void startElement(String uri, 
        String localName, String qName, Attributes attributes) throws SAXException {
    }

    @Override
    public void endElement(String uri, 
        String localName, String qName) throws SAXException {
    }

    @Override
    public void characters(char ch[], int start, int length) throws SAXException {
    }
};
SAXParserFactory factory = SAXParserFactory.newInstance();
SAXParser parser = factory.newSAXParser();
InputStream in = new ByteArrayInputStream(bytes);
parser.parse(in, handler);