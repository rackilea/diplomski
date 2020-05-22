for (int i = 0; i < nodeList.getLength(); i++) {
    Node currentNode = nodeList.item(i);
    if (currentNode.getNodeType() == Node.ELEMENT_NODE) {
        Node child = currentNode.getFirstChild();
        while(child != null) {
            if (child.getNodeType() == Node.TEXT_NODE) {
                child.setTextContent(StringEscapeUtils.escapeXml(child.getNodeValue()));
            }
            child = child.getNextSibling();
        }
    }
}