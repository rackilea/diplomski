NodeList nodeList = n.getChildNodes();
for (int j = 0; j < nodeList.getLength(); j++) {
    Node childNode = nodeList.item(j);
    if (childNode.getNodeType() == Node.ELEMENT_NODE) {
        System.out.println(childNode.getNodeName() + " " + childNode.getFirstChild().getNodeValue());
    }
}