public void balanceTree() {
    root = balanceTree(root);
}

private Node balanceTree(Node node) 
    if (node.left.getHits() <= node.getHits()
            && node.right.getHits() <= node.getHits()) {
        node.left = balanceTree(node.left);
        node.right = balanceTree(node.right);
    } else if (node.left.getHits() > node.getHits()) {
        node = rotateWithLeftChild(node);
    } else if (node.right.getHits() > node.getHits()) {
        node = rotateWithRightChild(node);
    }
    return node;
}