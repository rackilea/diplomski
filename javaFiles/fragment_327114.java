final String tagName = *** name of tag you are counting ***;
    InputStream in = *** stream of your xml ***;

    SAXParserFactory spf = SAXParserFactory.newInstance();
    SAXParser saxParser = spf.newSAXParser();
    final AtomicInteger counter = new AtomicInteger();
    saxParser.parse(in, new DefaultHandler() {
        @Override
        public void startElement (String uri, String localName, String qName, Attributes attributes) {
            if (localName.equals(tagName))
                counter.incrementAndGet();
        }
    });