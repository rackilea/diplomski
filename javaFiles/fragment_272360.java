if (node.getLeftChild() != null) {
    String found = getNodeValue(node.getLeftChild(), symbol);
    if (found != null) {
        return found;
    }
}
if (node.getRightChild() != null) {
    String found = getNodeValue(node.getRightChild(), symbol);
    if (found != null) {
        return found;
    }
}