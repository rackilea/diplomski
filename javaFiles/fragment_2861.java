public class Test extends DefaultHandler {

    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException, XPathExpressionException, XMLStreamException {
        SAXParser parser = SAXParserFactory.newInstance().newSAXParser();
        parser.parse(new File("src/file.xml"), new Test());
    }

    private String currentName;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        currentName = qName;
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String string = new String(ch, start, length);
        if (hasText(string)) {
            System.out.println(currentName);
            System.out.println(string);
        }
    }

    private boolean hasText(String string) {
        string = string.trim();
        return string.length() > 0;
    }
}