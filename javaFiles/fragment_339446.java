public void removeLeaves(BinaryTree n){
  if (n.left != null) {
    if (n.left.isLeaf()) {
      n.removeLeftChild();
    } else {
      removeLeaves(n.left);
    }
  }
  // repeat for right child
  // ...
}