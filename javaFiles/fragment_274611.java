StringBuilder tempVal = null;

public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
    //reset
    tempVal = new StringBuilder();
    ....
}

public void characters(char[] ch, int start, int length) throws SAXException {
    tempVal.append(ch, start, length);
}

public void endElement(String uri, String localName, String qName) throws SAXException {
    String textValue = tempVal.toString();
    ....
    }
}