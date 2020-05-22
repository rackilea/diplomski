//DISCLAIMER: untested code
public BinaryTreeNode findMaxNode(BinaryTreeNode t) {
    if (t == null)
        return null;
    BinaryTreeNode max = t;
    BinaryTreeNode maxLeft = findMax(t.rightChild);
    BinaryTreeNode maxRight = findMax(t.leftChild);
    if (maxLeft!=null && maxLeft.element > t.element) {
        max = maxLeft;
    }
    if (maxRight !=null && maxRight .element > t.element) {
        max = maxRight ;
    }
    return max;
}