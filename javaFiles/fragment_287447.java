public static void main(final String[] args)
    throws ParserConfigurationException, SAXException, IOException {
File xml = new File(file);
DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
Document doc = dBuilder.parse(xml);
doc.getDocumentElement().normalize();

NodeList nodes = doc.getElementsByTagName("messages");

for (int i = 0; i < nodes.getLength(); i++) {
    Node node = nodes.item(i);
    for (int j = 0; j < node.getChildNodes().getLength(); j++) {

    Node child = node.getChildNodes().item(j);

    if (!child.getNodeName().equals("#text")) {
        NamedNodeMap attributes = child.getAttributes();

        System.out.println("Type: " + child.getNodeName()
            + " packet ID " + attributes.getNamedItem("id")
            + " - class: " + attributes.getNamedItem("class"));
    }
    }
}
}