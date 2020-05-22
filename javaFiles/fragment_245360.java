public Node search(Node root, int searchId) {
    if (root.id == searchId) {
        return root;
    } else {
        for (Node child : root.childs) {
            Node node = search(child, searchId);
            if (node != null) {
                return node;
            }
        }
    }
    return null;
}

public void insert(Node node) {
    Node parent = search(root, node.parentId);
    if (node != null) {
        parent.childs.add(node);
    }
}