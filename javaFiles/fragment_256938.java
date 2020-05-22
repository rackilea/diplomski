public List<Node> nodes GetAllNodes(Node root) {
    List<Node> nodes = new ArrayList<Node>();
    if (root != null) {
        nodes.addAll(GetAllNodes(root.left));
        nodes.add(root);
        nodes.addAll(GetAllNodes(root.right));
    }
    return nodes;
}