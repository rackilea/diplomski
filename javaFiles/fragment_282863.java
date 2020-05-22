class ParserHandler extends org.xml.sax.helpers.DefaultHandler{
    @Override
    public void startDocument() throws SAXException {
    // your operation
    }

    //other methods 
}
ParserHandler handler = new ParserHandler();
SAXParserFactory factory = SAXParserFactory.newInstance();
factory.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, false);
SAXParser saxParser = factory.newSAXParser();
saxParser.parse(file, handler);