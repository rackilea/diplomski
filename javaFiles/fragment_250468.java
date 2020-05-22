if(this.searchNode(n._leftChild, c) != null) {
    return this.searchNode(n._leftChild, c);
}
if(this.searchNode(n._rightChild, c) != null) {
    return this.searchNode(n._rightChild, c);
}