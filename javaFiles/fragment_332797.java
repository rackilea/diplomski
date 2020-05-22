public abstract class XMLExporter<T> {
    public void generateXML(T object) throws ParserConfigurationException, TransformerException{
        Document doc = createDomDoc();
        fillXML(doc, object);
    }

    public abstract void fillXML(Document doc, T object) throws TransformerException;
}