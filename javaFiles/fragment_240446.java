public boolean insertNode(Node node) {
    if (root == null) {
        root = node;
        root.setColor(Node.BLACK);
        return true;
    } else {
        boolean result = insertNode(node, root);

        if (result) {
            //Some other important stuff to do...
        }

        return result;
    }
}

public boolean insertNode(Node node, Node current_node) {
    int value = current_node.getValue();

    if (node.getValue() < value) {
        if (current_node.getLeft() != null) {
            // Investigate left
            return insertNode(node, current_node.getLeft());
        } else {
            // Insert node left
            return true;
        }
    } else if (node.getValue() > value) {
        if (current_node.getRight() != null) {
            // Investigate right
            return insertNode(node, current_node.getRight());
        } else {
            // Insert node right
            return true;
        }
    } else {
        return false;
    }
}