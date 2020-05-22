public class Handler extends DefaultHandler {

    private StringBuilder sb = new StringBuilder();
    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        sb.append(ch, start, length);

    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        doStuffWith(sb.toString());
        sb = new StringBuilder();
    }
}