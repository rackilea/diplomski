@Test
public void sax_parser_read_much_things_before_returning_events() throws Exception{
    final String xml = "<a>"
               + "  <b>..</b>"
               + "  <c>..</c>"
                  // much more ...
               + "</a>";

    // wrapper to show what is read
    InputStream is = new InputStream() {
        InputStream is = new ByteArrayInputStream(xml.getBytes());

        @Override
        public int read() throws IOException {
            int val = is.read();
            System.out.print((char) val);
            return val;
        }
        @Override
        public int read(byte[] b, int off, int len) throws IOException {
            return super.read(b, off, 1);
        }
    };

    SAXParser parser = SAXParserFactory.newInstance().newSAXParser();
    parser.parse(is, new DefaultHandler(){
        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            System.out.print("\nHandler start: " + qName);
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            System.out.print("\nHandler end: " + qName);
        }
    });
}