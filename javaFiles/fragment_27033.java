public int getDepth(Node root, String data) {
    if (root == null || root.getData().getName().equals(data)) {
        // you hit the spot - either you are below a leaf
        // or you matched the node
        // if you were doing insert/replace, you would put the data on this spot
        return 0;
    }

    if (isSmallerThan(data, root.getData().getName())) {
        return 1 + getDepth(root.leftChild, data);
    }
    return 1 + getDepth(root.rightChild, data);
}