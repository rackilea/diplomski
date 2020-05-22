public class Main {
private final static String input = "<TXNURN>3505</TXNURN><CH></CH><REQ>N</REQ><DOB></DOB><QT>2</QT><DR>TAGER00</DR><NUMBER>N</NUMBER>";

public static void main(String[] args) throws Exception {
    SAXParser parser = SAXParserFactory.newInstance().newSAXParser();
    final StringBuilder output = new StringBuilder();
    parser.parse(new StringBufferInputStream("<root>"+input+"</root>"), new DefaultHandler() {
        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            if ("root".equals(qName)) return;
            output.append(qName).append(":");
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if ("root".equals(qName)) return;
            output.append("\n");
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            output.append(" ").append(ch, start, length);
        }
    });

    System.out.println(output.toString());
}