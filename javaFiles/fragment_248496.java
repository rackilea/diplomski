NodeList children = element.getChildNodes();
for (int i = 0; i < children.getLength(); i++) {
    Node node = children.item(i);
    if (node.getNodeType() == Node.ELEMENT_TYPE
        && node.getLocalName().equals("type")) {
        // Use the node, get its value etc
    }
}