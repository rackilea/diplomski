...
private boolean skipChildren;
private StringBuilder buf = new StringBuilder();
...

@Override
public void startElement(String uri, String localName, String qName,
        Attributes attributes) throws SAXException {
    if (qName.equals("parent")) {
        skipChildren = false;
        ...
    } else if (qName.equals("child1")) {
        buf.setLength(0);
        ...
    } else if (qName.startsWith("child")) {
        if (!skipChildren) {
            buf.setLength(0);
            ...
        }
    }
}

@Override
public void endElement(String uri, String localName, String qName)
        throws SAXException {
    if (qName.equals("parent")) {
        ...
    } else if (qName.equals("child1")) {
        int value = Integer.parseInt(buf.toString().trim());
        if (value <= 20) {
            skipChildren = true;
        }
        ...
    } else if (qName.startsWith("child")) {
        if (!skipChildren) {
            int value = Integer.parseInt(buf.toString().trim());
            doSomethingWith(value);
        }
    }
}

@Override
public void characters(char[] ch, int start, int length) {
    if (!skipChildren) {
        buf.append(ch, start, length);
    }
}