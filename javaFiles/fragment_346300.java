public static void recurseNode(Node node) {
        System.out.println(node.getNodeName() + node.getTextContent());

        NodeList nodeList = node.getChildNodes();
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node currentNode = nodeList.item(i);
            if (currentNode.getNodeType() == Node.ELEMENT_NODE) {
                // calls this method for all the children which is Element
                recurseNode(currentNode);
            }
        }