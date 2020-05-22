reader.setContentHandler(new DefaultHandler2() {

            private String currentLocalName;

            @Override
            public void startElement(String uri, String localName, String qName, Attributes attributes)
                    throws SAXException {

                currentLocalName = localName;
            }

            @Override
            public void characters(char[] ch, int start, int length) throws SAXException {
                  // read data here
         }