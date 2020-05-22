public class CDataXMLStreamWriter extends DelegatingXMLStreamWriter {

    private int counter = 1;

    private String currentElementName;

    public CDataXMLStreamWriter(XMLStreamWriter del) {
        super(del);
    }

    @Override
    public void writeCharacters(String text) throws XMLStreamException {
        boolean useCData = checkIfCDATAneededForCurrentElement();
        if (useCData) {
            super.writeCData(text);
        } else {
            super.writeCharacters(text);
        }
    }

    private boolean checkIfCDATAneededForCurrentElement() {
        if ("data".equals(currentElementName))
            return true;
        return false;
    }

    public void writeStartElement(String prefix, String local, String uri) throws XMLStreamException {
        currentElementName = local;
        super.writeStartElement(prefix, local, uri);
    }

    @Override
    public void writeEndElement() throws XMLStreamException {
        if ("data".equals(currentElementName)) {
            if (this.counter == 1) {
                super.writeEndElement();
            }
            this.counter++;
        } else {
            super.writeEndElement();
        }

    }

}