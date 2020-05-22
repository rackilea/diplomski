@XmlRootElement
public class Root {

public Container c;

@XmlAnyElement
public void setElements(Element e) throws JAXBException, ParserConfigurationException {
    Document d = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
    Element container = d.createElement("container");
    d.appendChild(container);
    Node node = d.adoptNode(e.getFirstChild());
    container.appendChild(node);
    c = (Container) JAXBContext.newInstance(Container.class).createUnmarshaller().unmarshal(d);
}

public Element getElements() {
    throw new UnsupportedOperationException();
}
}