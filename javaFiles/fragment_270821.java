List<Node> topLevelClusterElements = new ArrayList<Node>();

NodeList childNodes = doc.getDocumentElement().getChildNodes();
for(int i = 0; i < childNodes.getLength(); i++) {
    Node childNode = childNodes.item(i);
    if(childNode.getNodeType() == Node.ELEMENT_NODE && childNode.getNodeName().equals("Cluster")) {
        Element clusterElement = (Element) childNode;
        topLevelClusterElements.add(clusterElement);
    }
}