InputStream in = ...
XMLInputFactory factory = XMLInputFactory.newInstance();
XMLEventReader eventReader = factory.createXMLEventReader(in);

boolean found = false;
while (!found && eventReader.hasNext()) {
    XMLEvent event = eventReader.nextEvent();
    switch (event.getEventType()) {
    case XMLStreamConstants.START_ELEMENT:
        // your logic here 
        // once you found your element, you can terminate the loop 
        found = true;
        break;
    case XMLStreamConstants.END_ELEMENT:
        // your logic here
        break;
    }
}