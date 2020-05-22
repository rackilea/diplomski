public class XMLExportStreamWriter extends DelegateXMLStreamWriter {

private Set<String> nillableElements;
private final Stack<String> path = new Stack<>();

private boolean nillable;
private boolean notNull;

private String localName;
private String namespaceURI;
private String prefix;

public XMLExportStreamWriter(XMLStreamWriter delegate) throws XMLStreamException {
    super.setDelegate(delegate);
}

public void setNillableElements(Set<String> nillableElements) {
    this.nillableElements = nillableElements;
}

@Override
public void writeStartElement(String localName) throws XMLStreamException {
    if (!isNillable(localName)) {
        super.writeStartElement(localName);
    } else {
        setElementArgs(null, localName, null);
    }
}

@Override
public void writeStartElement(String namespaceURI, String localName) throws XMLStreamException {
    if (!isNillable(localName)) {
        super.writeStartElement(namespaceURI, localName);
    } else {
        setElementArgs(null, localName, namespaceURI);
    }
}

@Override
public void writeStartElement(String prefix, String localName, String namespaceURI)
    throws XMLStreamException {
    if (!isNillable(localName)) {
        super.writeStartElement(prefix, localName, namespaceURI);
    } else {
        setElementArgs(prefix, localName, namespaceURI);
    }
}

@Override
public void writeEndElement() throws XMLStreamException {
    if (!this.nillable || this.notNull) {
        super.writeEndElement();
    }
    this.path.pop();
    if (this.nillable) {
        this.nillable = this.nillableElements.contains(toPath());
    }
}

@Override
public void writeCharacters(String text) throws XMLStreamException {
    if (this.nillable) {
        if (text != null) {
            this.notNull = true;
            forceStartElement();
            super.writeCharacters(text);
        }
    } else {
        super.writeCharacters(text);
    }
}

@Override
public void writeCharacters(char[] text, int start, int len) throws XMLStreamException {
    if (this.nillable) {
        if (text != null) {
            this.notNull = true;
            forceStartElement();
            super.writeCharacters(text, start, len);
        }
    } else {
        super.writeCharacters(text, start, len);
    }
}

@Override
public void writeAttribute(String localName, String value) throws XMLStreamException {
    if (!this.nillable) {
        super.writeAttribute(localName, value);
    }
}

@Override
public void writeAttribute(String namespaceURI, String localName, String value)
    throws XMLStreamException {
    if (!this.nillable) {
        super.writeAttribute(namespaceURI, localName, value);
    }
}

@Override
public void writeAttribute(String prefix, String namespaceURI, String localName, String value)
    throws XMLStreamException {
    if (!this.nillable) {
        super.writeAttribute(prefix, namespaceURI, localName, value);
    }
}

@Override
public void writeNamespace(String prefix, String namespaceURI) throws XMLStreamException {
    if (!this.nillable) {
        super.writeNamespace(prefix, namespaceURI);
    }
}

private void forceStartElement() throws XMLStreamException {
    if (this.prefix != null) {
        super.writeStartElement(this.prefix, this.localName, this.namespaceURI);
    } else if (this.namespaceURI != null) {
        super.writeStartElement(this.namespaceURI, this.localName);
    } else {
        super.writeStartElement(this.localName);
    }
}

private boolean isNillable(String localName) {
    this.notNull = false;
    this.path.push(localName);
    this.nillable = this.nillableElements.contains(toPath());
    return this.nillable;
}

private void setElementArgs(String prefix, String localName, String namespaceURI) {
    this.prefix = prefix;
    this.localName = localName;
    this.namespaceURI = namespaceURI;
}

private String toPath() {
    StringBuilder sb = new StringBuilder();
    boolean first = true;
    for (String element : this.path) {
        if (first) {
            first = false;
        } else {
            sb.append('/');
        }
        sb.append(element);
    }
    return sb.toString();
}

}