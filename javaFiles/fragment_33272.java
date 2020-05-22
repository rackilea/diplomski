public static List<Node> returnAllNodes(Node node){
    List<Node> listOfNodes = new ArrayList<Node>();
    if (node != null) {
        listOfNodes.add(node);
        for(int i = 0; i < listOfNodes.size(); ++i) {
            Node n = listOfNodes.get(i);
            List<Node> children = n.getChildren();
            if (children != null) {
                for (Node child: children) {
                    if (!listOfNodes.contains(child)) {
                        listOfNodes.add(child);
                    }
                }
            }
        }
    }
    return listOfNodes;
}