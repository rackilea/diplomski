public static Node getNode(Node currentNode, String name){
    // Base case: currentNode is null, nothing left to search
    if (currentNode == null) {
        return null;
    }

    Node retrieved = null;
    if (currentNode.name.equals(name)) {
        return currentNode;
    } else {
        // Tail recursions
        if(currentNode.left == null) {
            return getNode(currentNode.right, name);
        }
        else if(currentNode.right == null) {
            return getNode(currentNode.left, name);
        }
        // Non Tail recursion
        else {
        retrieved = getNode(currentNode.left, name);

            // If not found in left subtree, then search right subtree
            if (retrieved == null){
                retrieved = getNode(currentNode.right, name);
            }
        }
    }
    return retrieved;
}