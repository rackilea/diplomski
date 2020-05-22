private void addNode(TreeNode<Type> current, TreeNode<Type> newNode) {

current = root;
if (current == null) {
    current = newNode;
} else if (newNode.getValue().compareTo(current.getValue()) < 0) {

    if (current.getLeft() == null) {
        current.setLeft(newNode);

    } else {
        addNode(current.getLeft(), newNode);
    }