for(int i = 0; i < nodeList.getLength(); i++) {
    Node node = nodeList.item(i);

    if(node.getNodeName() == "Gender")
        node.setTextContent("F");
    if(node.getNodeName() == "PrimaryResidence")
        node.setTextContent("OwnCondo");
}