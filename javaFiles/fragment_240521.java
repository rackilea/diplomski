public class RemoveFirstCharacter implements XMLStreamWriter {

    private final XMLStreamWriter delegate;

    public RemoveFirstCharacter(final XMLStreamWriter delegate) {
        this.delegate = delegate;
    }

    @Override
    public void writeStartElement(final String localName) throws XMLStreamException {
        delegate.writeStartElement(localName);
    }

    @Override
    public void writeStartElement(final String namespaceURI, final String localName) 
        throws XMLStreamException {
        delegate.writeStartElement(namespaceURI, localName);
    }

    ...

    @Override
    public void writeCharacters(final String text) throws XMLStreamException {
        // Skip the first character
        delegate.writeCharacters(text.substring(1));
    }

    @Override
    public void writeCharacters(final char[] text, final int start, final int len)
        throws XMLStreamException {
        if (start == 0) {
            // Skip the first character
            delegate.writeCharacters(text, 1, len - 1);
        } else {
            delegate.writeCharacters(text, start, len);
        }
    }
}