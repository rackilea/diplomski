// Only check in elements, and only those which actually have attributes.
if (node.hasAttributes()) {
    NamedNodeMap attributes = node.getAttributes();
    Node nameAttribute = attributes.getNamedItem("Name");
    if (nameAttribute != null) {
        System.out.println("Name attribute: " + nameAttribute.getTextContent());
    }
}