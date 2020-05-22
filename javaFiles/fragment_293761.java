private void iterateNodes(Node node) {

    System.out.println("Node: " + node.getNodeName());
    NodeList nodeList = node.getChildNodes();

    for (int i = 0; i < nodeList.getLength(); i++) {
        Node currentode = nodeList.item(i);

        System.out.println(currentode.getNodeName());

        if (currentode.getNodeType() == Node.ELEMENT_NODE) {
            Element element = (Element) currentode;
            iterateNodes(element);
        }
    }
}