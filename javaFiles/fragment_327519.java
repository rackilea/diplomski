float add(final BinaryTree node) {
if (node == null) {
   return 0;
}

return (float)node.rootValue()+ add(node.leftChild()) + add(node.rightChild());
}