import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;

import org.apache.cxf.staxutils.DelegatingXMLStreamWriter;

public class CDataContentWriter extends DelegatingXMLStreamWriter {

    public CDataContentWriter(XMLStreamWriter writer) {
        super(writer);
    }

    public void writeCharacters(String text) throws XMLStreamException {
        boolean useCData = text.contains("RequestGeneric");
        if (useCData) {
            super.writeCData(text);
        } else {
            super.writeCharacters(text);
        }
    }

    // optional 
    public void writeStartElement(String prefix, String local, String uri) throws XMLStreamException {
        super.writeStartElement(prefix, local, uri);
    }
}