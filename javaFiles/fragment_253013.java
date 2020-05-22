private BSTNode<E> getPrevNode(BSTNode<E> node) {

    if(node.left != null) {
        node = node.left;
        while(node.right != null) {
            node = node.right;
        }
        return node;
    } else if(node.parent != null) {

        // If the node is a right child, return its parent
        if(node.parent.right == node) {
            return node.parent;
        }

        // If the node is a left child, move up the tree 
        // until you are a right child and return its parent
        if(node.parent.left == node) {

            while(node.parent.right != node) {

                // If you reach the root and are never a right child, no previous node return null
                if(node.parent == root) {
                    return null;
                }
                node = node.parent; 
            }
            return node.parent;

        }           
    }

    return null;
}