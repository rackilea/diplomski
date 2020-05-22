else if (node.getNodeType() == Node.ELEMENT_NODE) {
    // do something with the current element
    System.out.print(node.getNodeName()+"= ");
    NodeList cNodes = node.getChildNodes();
    for(int j = 0;j< cNodes.getLength();j++) {
        Node cN = cNodes.item(j);
        if(cN.getNodeType() == Node.TEXT_NODE) {
             System.out.println(cN.getTextContent());
        }
    }
}