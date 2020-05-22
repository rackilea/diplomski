public static void main(String[] args) throws Exception {
    SAXParserFactory factory = SAXParserFactory.newInstance();
    SAXParser saxParser = factory.newSAXParser();

    DefaultHandler handler = new DefaultHandler() {
        boolean maxElement = false;

        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {

            if (qName.equalsIgnoreCase(MAX)) {
                maxElement = true;
            }

        }

        public void endElement(String uri, String localName, String qName) throws SAXException {
        }

        public void characters(char ch[], int start, int length) throws SAXException {

            if (maxElement) {
                String maxString = new String(ch, start, length);
                Double maxDouble = Double.parseDouble(maxString);
                System.out.println(MAX + SPACE + maxDouble);
                maxElement = false;
            }
        }
    };

    saxParser.parse("your_xml_file.xml", handler);
}