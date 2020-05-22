import java.util.Iterator;

import javax.xml.namespace.NamespaceContext;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;

public class MyXMLStreamWriter implements XMLStreamWriter {

    private XMLStreamWriter xsw;
    private MyNamespaceContext nc = new MyNamespaceContext();

    public MyXMLStreamWriter(XMLStreamWriter xsw) throws Exception {
        this.xsw = xsw;
        xsw.setNamespaceContext(nc);
    }

    public void close() throws XMLStreamException {
        xsw.close();
    }

    public void flush() throws XMLStreamException {
        xsw.flush();
    }

    public NamespaceContext getNamespaceContext() {
        return xsw.getNamespaceContext();
    }

    public String getPrefix(String arg0) throws XMLStreamException {
        return xsw.getPrefix(arg0);
    }

    public Object getProperty(String arg0) throws IllegalArgumentException {
        return xsw.getProperty(arg0);
    }

    public void setDefaultNamespace(String arg0) throws XMLStreamException {
        xsw.setDefaultNamespace(arg0);
    }

    public void setNamespaceContext(NamespaceContext arg0) throws XMLStreamException {
    }

    public void setPrefix(String arg0, String arg1) throws XMLStreamException {
        xsw.setPrefix(arg0, arg1);
    }

    public void writeAttribute(String arg0, String arg1) throws XMLStreamException {
        xsw.writeAttribute(arg0, arg1);
    }

    public void writeAttribute(String arg0, String arg1, String arg2) throws XMLStreamException {
        xsw.writeAttribute(arg0, arg1, arg2);
    }

    public void writeAttribute(String arg0, String arg1, String arg2, String arg3) throws XMLStreamException {
        xsw.writeAttribute(arg0, arg1, arg2, arg3);
    }

    public void writeCData(String arg0) throws XMLStreamException {
        xsw.writeCData(arg0);
    }

    public void writeCharacters(String arg0) throws XMLStreamException {
        xsw.writeCharacters(arg0);
    }

    public void writeCharacters(char[] arg0, int arg1, int arg2) throws XMLStreamException {
        xsw.writeCharacters(arg0, arg1, arg2);
    }

    public void writeComment(String arg0) throws XMLStreamException {
        xsw.writeComment(arg0);
    }

    public void writeDTD(String arg0) throws XMLStreamException {
        xsw.writeDTD(arg0);
    }

    public void writeDefaultNamespace(String arg0) throws XMLStreamException {
        xsw.writeDefaultNamespace(arg0);
    }

    public void writeEmptyElement(String arg0) throws XMLStreamException {
        xsw.writeEmptyElement(arg0);
    }

    public void writeEmptyElement(String arg0, String arg1) throws XMLStreamException {
        xsw.writeEmptyElement(arg0, arg1);
    }

    public void writeEmptyElement(String arg0, String arg1, String arg2) throws XMLStreamException {
        xsw.writeEmptyElement(arg0, arg1, arg2);
    }

    public void writeEndDocument() throws XMLStreamException {
        xsw.writeEndDocument();
    }

    public void writeEndElement() throws XMLStreamException {
        xsw.writeEndElement();
    }

    public void writeEntityRef(String arg0) throws XMLStreamException {
        xsw.writeEntityRef(arg0);
    }

    public void writeNamespace(String arg0, String arg1) throws XMLStreamException {
    }

    public void writeProcessingInstruction(String arg0) throws XMLStreamException {
        xsw.writeProcessingInstruction(arg0);
    }

    public void writeProcessingInstruction(String arg0, String arg1) throws XMLStreamException {
        xsw.writeProcessingInstruction(arg0, arg1);
    }

    public void writeStartDocument() throws XMLStreamException {
        xsw.writeStartDocument();
    }

    public void writeStartDocument(String arg0) throws XMLStreamException {
        xsw.writeStartDocument(arg0);
    }

    public void writeStartDocument(String arg0, String arg1) throws XMLStreamException {
        xsw.writeStartDocument(arg0, arg1);
    }

    public void writeStartElement(String arg0) throws XMLStreamException {
        xsw.writeStartElement(arg0);
    }

    public void writeStartElement(String arg0, String arg1) throws XMLStreamException {
        xsw.writeStartElement(arg0, arg1);
    }

    public void writeStartElement(String arg0, String arg1, String arg2) throws XMLStreamException {
        xsw.writeStartElement("", arg1, arg2);
        if(null != arg2 || arg2.length() > 0) {
            String currentDefaultNS = nc.getNamespaceURI("");
            if(!arg2.equals(currentDefaultNS)) {
                writeDefaultNamespace(arg2);
                nc.setDefaultNS(arg2);
            }
        }
     }

    private static class MyNamespaceContext implements NamespaceContext {

        private String defaultNS = "";

        public void setDefaultNS(String ns) {
            defaultNS = ns;
        }

        public String getNamespaceURI(String arg0) {
            if("".equals(arg0)) {
                return defaultNS;
            }
            return null;
        }

        public String getPrefix(String arg0) {
            return "";
        }

        public Iterator getPrefixes(String arg0) {
            return null;
        }

    }
}