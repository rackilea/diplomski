private ElementHandler currentHandler;
private StringBuilder buffer = new StringBuilder();
private Map<String, ElementHandler> handlers = new HashMap<String, ElementHandler>();

public void registerHandler(String qName, ElementHandler handler) {
    handlers.put(qName, handler);
}    

public void startElement (String uri, String local, String qName, Attributes atts) throws SAXException {
    currentHandler = handlers.get(qName);
    buffer.delete(0, buffer.length());
}

public void characters (char buf [], int offset, int length) throws SAXException {
    if (currentHandler != null) {
        buffer.append(buf, offset, length);
    }
}

public void endElement (String uri, String local, String qName) throws SAXException {
    if (currentHandler != null) {
        currentHandler.handle(buffer.toString();
    }
}