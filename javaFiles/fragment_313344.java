public void startElement(String namespaceURI,
                     String localName,
                     String qName,
                     Attributes atts)
              throws SAXException {
    // ...
    throw new SAXException(new BreakParsingException());
}