public void node() {
    Node[] allNodes = new Node[5000];

    //Print out all node values
    for (Node currentNode : allNodes) {
        currentNode.setNodeValue("Some value");
        System.out.println("Name: " + currentNode.getNodeValue());
    }
}