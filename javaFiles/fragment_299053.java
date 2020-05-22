public static void childRecusrsion(Node node) {
        // do something with the current node instead of System.out
        System.out.println(node.getNodeName());

        NodeList nodeList = node.getChildNodes(); //gets the child nodes that you need
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node currentNode = nodeList.item(i);
            if (currentNode.getNodeType() == Node.ELEMENT_NODE) {
                //call the recursion
                childRecusrsion(currentNode);
            }
        }
    }