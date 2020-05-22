public String toXmlString(Node node) throws TransformerException {
    final DOMBuilder builder = new DOMBuilder();
    final Element element = (Element) node;
    final org.jdom2.Element jdomElement = builder.build(element);

    final XMLOutputter xmlOutputter = new XMLOutputter(Format.getPrettyFormat());
    final String output = xmlOutputter.outputString(jdomElement);
    return output;
}