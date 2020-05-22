public final class FilteredXmlEventReader extends EventReaderDelegate {

    final Set<String> filteredElements;

    FilteredXmlEventReader(XMLEventReader delegate, String... filteredElements) {
        super(delegate);
        this.filteredElements = new HashSet<String>(Arrays.asList(filteredElements));
    }

    public XMLEvent nextEvent() throws XMLStreamException {
        // Read next event

        XMLEvent e = super.nextEvent();
        // If it's a start element for any filtered
        if (e.getEventType() == XMLEvent.START_ELEMENT && filteredElements.contains(e.asStartElement().getName().getLocalPart())) {
            String element = e.asStartElement().getName().getLocalPart();
            // Then run through events until a closing similar element
            do {
                e = super.nextEvent();
            } while (e.getEventType() != XMLEvent.END_ELEMENT || !element.equals(e.asEndElement().getName().getLocalPart()));
            // then read next tag after closing element
            e = super.nextEvent();
        }
        return e;
    }
}