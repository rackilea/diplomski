public static List<Node> returnAllNodes(Node node){
    List<Node> listOfNodes = new ArrayList<Node>();
    addAllNodes(node, listOfNodes);
    return listOfNodes;
}

private static void addAllNodes(Node node, List<Node> listOfNodes) {
    if (node != null) {
        listOfNodes.add(node);
        List<Node> children = node.getChildren();
        if (children != null) {
            for (Node child: children) {
                addAllNodes(child, listOfNodes);
            }
        }
    }
}