public Node getNode(Key key, List<Node> children) {
    if (children != null) {
        for (Node child : children) {
            if (child.getKey().equals(key)) {
                return child;
            } else {
                return getNode(key, child.getChildren());
            }
        }
    }
}