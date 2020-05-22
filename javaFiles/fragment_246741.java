NodeList nodeList = soapHeader.getElementsByTagName("*");

for (int i = 0; i < nodeList.getLength(); i++) {
    Node node = nodeList.item(i);
    if (node.getNodeType() == Node.ELEMENT_NODE 
            && node.getLocalName().equalsIgnoreCase(propertyName)) {
            if (node.getTextContent().isEmpty()) {
                    return null;
            } else {
                    return node.getTextContent();
            }
    }
}