for (int i = 0;i < nList.getLength(); i++) {
    Node node = nList.item(i);
    if (node.getNodeType() == Node.ELEMENT_NODE) {
        System.out.println("node name: " + node.getNodeName());
    }
}