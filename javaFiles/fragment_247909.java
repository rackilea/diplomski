NamedNodeMap attrs = childNode.getAttributes();

if (attrs != null) {
    for (int k = 0; k < attrs.getLength(); k++) {
        System.out.println("Attribute: "
                + attrs.item(k).getNodeName() + " = "
                + attrs.item(k).getNodeValue());
    }
}