Node result = null;

if (n != null) {
    ...
    result = this.searchNode(n._leftChild, c);
    if (result == null)
        result = this.searchNode(n._rightChild, c);
}
return result;