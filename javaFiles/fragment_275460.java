public void endElement(String uri, String localName, String qName)
        throws SAXException {
                    if (qName.equalsIgnoreCase("laptop")) {
        // create a new instance of Laptop
        laptop = new Laptop();

    }
   }