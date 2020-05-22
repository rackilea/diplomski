static void setChild(Node node, boolean toLeft, Node child){
    // Assign child node to the indicated direction: left or right
    if (toLeft) {
        node.left = child;
    } else {
        node.right = child;
    }
}

static Node splitTree(Node root, int k){
    Node root2 = null;
    Node parent1 = null;
    Node parent2 = null;
    // Determine at which side of the root we will travel
    boolean toLeft = root != null && k < root.data;

    while (root != null) {
        while (root != null && (k < root.data) == toLeft) {
            parent1 = root;
            root = toLeft ? root.left : root.right;
        }
        setChild(parent1, toLeft, null); // Cut out the edge. root is now detached
        toLeft = !toLeft; // toggle direction
        if (root2 == null) {
            root2 = root; // This is the root of the other tree.
        } else if (parent2 != null) {
            setChild(parent2, toLeft, root); // re-attach the detached subtree
        }
        parent2 = parent1;
        parent1 = null;
    }
    return root2;
}