import java.util.Set;
import javax.xml.namespace.QName;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;

public class FilteringlXmlEventReader implements XMLEventReader {

    final XMLEventReader reader;
    final Set<QName> qNames;

    public FilteringlXmlEventReader(XMLEventReader reader,
            Set<QName> qNames) {
        this.reader = reader;
        this.qNames = qNames;
    }

    @Override
    public XMLEvent nextEvent() throws XMLStreamException {
        while (tagToSkip(reader.peek())) {
            reader.nextEvent();
        }
        return reader.nextEvent();
    }

    // from XMLEventReader
    @Override
    public boolean hasNext() {
        return reader.hasNext();
    }

    @Override
    public XMLEvent peek() throws XMLStreamException {
        return reader.peek();
    }

    @Override
    public String getElementText() throws XMLStreamException {
        return reader.getElementText();
    }

    @Override
    public XMLEvent nextTag() throws XMLStreamException {
        return reader.nextTag();
    }

    @Override
    public Object getProperty(String name) throws IllegalArgumentException {
        return reader.getProperty(name);
    }

    // from Iterator
    @Override
    public Object next() {
        return reader.next();
    }

    @Override
    public void remove() {
        reader.remove();
    }

    @Override
    public void close() throws XMLStreamException {
        reader.close();
    }

    /**
     * Check if the name of the XML tag which has triggered the passed 
     * event is to be skipped.
     *
     * @param event the current event
     * @return {@code true} the event should be skipped, otherwise 
     * {@code false}
     */
    private boolean tagToSkip(XMLEvent event) {
        switch (event.getEventType()) {
            case XMLStreamConstants.START_ELEMENT:
                StartElement startTag = (StartElement) event;
                return qNames.contains(startTag.getName());
            case XMLStreamConstants.END_ELEMENT:
                EndElement endTag = (EndElement) event;
                return qNames.contains(endTag.getName());
        }
        return false;
    }
}