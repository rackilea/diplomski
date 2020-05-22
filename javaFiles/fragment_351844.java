StringBuilder builder;

@Override
public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
    if (qName.equalsIgnoreCase("content")) {
        builder = new StringBuilder();
    }
}

@Override
public void characters(char ch[], int start, int length) throws SAXException {
    if (builder != null){
        builder.append(new String(ch, start, length));
    }
}

@Override
public void endElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
    if (builder != null) {
        System.out.println("Content = " + builder);
        builder = null;
    }
}