@Override
public void startElement(final String uri, final String localName, final String qName, final Attributes attributes) {
    stringBuffer.setLength(0);

    if ("elementToRead1".equals(qName)) {
        flag1 = true;
    }
}

@Override
public void characters(char ch[], int start, int length) {
    stringBuffer.append(new String(ch, start, length));
}

@Override
public void endElement(String namespaceURI, String localName, String qName) throws SAXException {
    String result = stringBuffer.toString();

    if (flag1) {
        elementToRead1 = result;
        flag1 = false;
    }
}