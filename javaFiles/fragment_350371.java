import java.util.ArrayList;
import java.util.List;

import javax.xml.namespace.NamespaceContext;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;

class WrapperXMLStreamWriter implements XMLStreamWriter {

private final XMLStreamWriter writer;

public WrapperXMLStreamWriter(XMLStreamWriter writer) {
    this.writer = writer;
}

private List<String> namespaces = new ArrayList<String>();

public void init() {
    namespaces.clear();
}

@Override
public void writeStartElement(String localName) throws XMLStreamException {
    init();
    writer.writeStartElement(localName);

}

@Override
public void writeStartElement(String namespaceURI, String localName) throws XMLStreamException {
    init();
    writer.writeStartElement(namespaceURI, localName);
}

@Override
public void writeStartElement(String prefix, String localName, String namespaceURI) throws XMLStreamException {
    init();
    if (prefix.equalsIgnoreCase("xsi") || prefix.equalsIgnoreCase("xs")) {
        writer.writeStartElement(prefix, localName, namespaceURI);
    } else {
        writer.writeStartElement("", localName, namespaceURI);
    }
}

@Override
public void writeNamespace(String prefix, String namespaceURI) throws XMLStreamException {
    if (namespaces.contains(namespaceURI)) {
        return;
    }
    namespaces.add(namespaceURI);
    if (prefix.equalsIgnoreCase("xsi") || prefix.equalsIgnoreCase("xs")) {
        writer.writeNamespace(prefix, namespaceURI);
    } else {
        writer.writeNamespace("", namespaceURI);
    }
}

/*
 * (non-Javadoc)
 * @see javax.xml.stream.XMLStreamWriter#close()
 */
@Override
public void close() throws XMLStreamException {
    this.writer.close();
}

/*
 * (non-Javadoc)
 * @see javax.xml.stream.XMLStreamWriter#flush()
 */
@Override
public void flush() throws XMLStreamException {
    this.writer.flush();

}

/*
 * (non-Javadoc)
 * @see javax.xml.stream.XMLStreamWriter#getNamespaceContext()
 */
@Override
public NamespaceContext getNamespaceContext() {
    return this.writer.getNamespaceContext();
}

/*
 * (non-Javadoc)
 * @see javax.xml.stream.XMLStreamWriter#getPrefix(java.lang.String)
 */
@Override
public String getPrefix(String arg0) throws XMLStreamException {
    return this.writer.getPrefix(arg0);
}

/*
 * (non-Javadoc)
 * @see javax.xml.stream.XMLStreamWriter#getProperty(java.lang.String)
 */
@Override
public Object getProperty(String arg0) throws IllegalArgumentException {
    return this.writer.getProperty(arg0);
}

/*
 * (non-Javadoc)
 * @see javax.xml.stream.XMLStreamWriter#setDefaultNamespace(java.lang.String)
 */
@Override
public void setDefaultNamespace(String arg0) throws XMLStreamException {
    this.writer.setDefaultNamespace(arg0);
}

/*
 * (non-Javadoc)
 * @see javax.xml.stream.XMLStreamWriter#setNamespaceContext(javax.xml.namespace.NamespaceContext)
 */
@Override
public void setNamespaceContext(NamespaceContext arg0) throws XMLStreamException {
    this.writer.setNamespaceContext(arg0);
}

/*
 * (non-Javadoc)
 * @see javax.xml.stream.XMLStreamWriter#setPrefix(java.lang.String, java.lang.String)
 */
@Override
public void setPrefix(String arg0, String arg1) throws XMLStreamException {
    this.writer.setPrefix(arg0, arg1);
}

/*
 * (non-Javadoc)
 * @see javax.xml.stream.XMLStreamWriter#writeAttribute(java.lang.String, java.lang.String)
 */
@Override
public void writeAttribute(String arg0, String arg1) throws XMLStreamException {
    // TODO Auto-generated method stub
    this.writer.writeAttribute(arg0, arg1);
}

/*
 * (non-Javadoc)
 * @see javax.xml.stream.XMLStreamWriter#writeAttribute(java.lang.String, java.lang.String, java.lang.String)
 */
@Override
public void writeAttribute(String arg0, String arg1, String arg2) throws XMLStreamException {
    this.writer.writeAttribute(arg0, arg1, arg2);
}

/*
 * (non-Javadoc)
 * @see javax.xml.stream.XMLStreamWriter#writeAttribute(java.lang.String, java.lang.String, java.lang.String,
 * java.lang.String)
 */
@Override
public void writeAttribute(String arg0, String arg1, String arg2, String arg3) throws XMLStreamException {
    this.writer.writeAttribute(arg0, arg1, arg2, arg3);
}

/*
 * (non-Javadoc)
 * @see javax.xml.stream.XMLStreamWriter#writeCData(java.lang.String)
 */
@Override
public void writeCData(String arg0) throws XMLStreamException {
    this.writer.writeCData(arg0);
}

/*
 * (non-Javadoc)
 * @see javax.xml.stream.XMLStreamWriter#writeCharacters(java.lang.String)
 */
@Override
public void writeCharacters(String arg0) throws XMLStreamException {
    this.writer.writeCharacters(arg0);
}

/*
 * (non-Javadoc)
 * @see javax.xml.stream.XMLStreamWriter#writeCharacters(char[], int, int)
 */
@Override
public void writeCharacters(char[] arg0, int arg1, int arg2) throws XMLStreamException {
    this.writer.writeCharacters(arg0, arg1, arg2);
}

/*
 * (non-Javadoc)
 * @see javax.xml.stream.XMLStreamWriter#writeComment(java.lang.String)
 */
@Override
public void writeComment(String arg0) throws XMLStreamException {
    this.writer.writeComment(arg0);
}

/*
 * (non-Javadoc)
 * @see javax.xml.stream.XMLStreamWriter#writeDTD(java.lang.String)
 */
@Override
public void writeDTD(String arg0) throws XMLStreamException {
    this.writer.writeDTD(arg0);
}

/*
 * (non-Javadoc)
 * @see javax.xml.stream.XMLStreamWriter#writeDefaultNamespace(java.lang.String)
 */
@Override
public void writeDefaultNamespace(String arg0) throws XMLStreamException {
    this.writer.writeDefaultNamespace(arg0);
}

/*
 * (non-Javadoc)
 * @see javax.xml.stream.XMLStreamWriter#writeEmptyElement(java.lang.String)
 */
@Override
public void writeEmptyElement(String arg0) throws XMLStreamException {
    this.writer.writeEmptyElement(arg0);
}

/*
 * (non-Javadoc)
 * @see javax.xml.stream.XMLStreamWriter#writeEmptyElement(java.lang.String, java.lang.String)
 */
@Override
public void writeEmptyElement(String arg0, String arg1) throws XMLStreamException {
    this.writer.writeEmptyElement(arg0, arg1);
}

/*
 * (non-Javadoc)
 * @see javax.xml.stream.XMLStreamWriter#writeEmptyElement(java.lang.String, java.lang.String, java.lang.String)
 */
@Override
public void writeEmptyElement(String arg0, String arg1, String arg2) throws XMLStreamException {
    this.writer.writeEmptyElement(arg0, arg1, arg2);
}

/*
 * (non-Javadoc)
 * @see javax.xml.stream.XMLStreamWriter#writeEndDocument()
 */
@Override
public void writeEndDocument() throws XMLStreamException {
    this.writer.writeEndDocument();
}

/*
 * (non-Javadoc)
 * @see javax.xml.stream.XMLStreamWriter#writeEndElement()
 */
@Override
public void writeEndElement() throws XMLStreamException {
    this.writer.writeEndElement();
}

/*
 * (non-Javadoc)
 * @see javax.xml.stream.XMLStreamWriter#writeEntityRef(java.lang.String)
 */
@Override
public void writeEntityRef(String arg0) throws XMLStreamException {
    this.writer.writeEntityRef(arg0);
}

/*
 * (non-Javadoc)
 * @see javax.xml.stream.XMLStreamWriter#writeProcessingInstruction(java.lang.String)
 */
@Override
public void writeProcessingInstruction(String arg0) throws XMLStreamException {
    this.writer.writeProcessingInstruction(arg0);
}

/*
 * (non-Javadoc)
 * @see javax.xml.stream.XMLStreamWriter#writeProcessingInstruction(java.lang.String, java.lang.String)
 */
@Override
public void writeProcessingInstruction(String arg0, String arg1) throws XMLStreamException {
    this.writer.writeProcessingInstruction(arg0, arg1);
}

/*
 * (non-Javadoc)
 * @see javax.xml.stream.XMLStreamWriter#writeStartDocument()
 */
@Override
public void writeStartDocument() throws XMLStreamException {
    this.writer.writeStartDocument();
}

/*
 * (non-Javadoc)
 * @see javax.xml.stream.XMLStreamWriter#writeStartDocument(java.lang.String)
 */
@Override
public void writeStartDocument(String arg0) throws XMLStreamException {
    this.writer.writeStartDocument(arg0);
}

/*
 * (non-Javadoc)
 * @see javax.xml.stream.XMLStreamWriter#writeStartDocument(java.lang.String, java.lang.String)
 */
@Override
public void writeStartDocument(String arg0, String arg1) throws XMLStreamException {
    this.writer.writeStartDocument(arg0, arg1);
}