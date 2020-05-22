public String find(TreeNode currentNode, String value) {
    if (currentNode == null) {
        return null;
    }

    if(currentNode.getData().compareToIgnoreCase(value) == 0) {
        return currentNode.getData(); //not executing
    }

    if (currentNode.getData().compareToIgnoreCase(value) > 0) {
        return find(currentNode.getLeft(), value);
    } else {
        return find(currentNode.getRight(), value);
    }
}