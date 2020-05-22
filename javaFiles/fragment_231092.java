@XmlRootElement(name = "document")
@XmlAccessorType(XmlAccessType.FIELD)
public class PDFDocument {

@XmlElement(name = "properties")
private DocumentProperty documentProperty;

public DocumentProperty getDocumentProperty() {
    return documentProperty;
}

public void setDocumentProperty(DocumentProperty documentProperty) {
    this.documentProperty = documentProperty;
}

@Override
public String toString() {
    return "PDFDocument{" +
            "documentProperty=" + documentProperty + "\n" +
            '}';
}
}