public static void replaceRandom(Tree<T> tree, Node<T> newNode) { 
  // Find a random node
  List<Node<T>> nodeList = tree.getPreOrderTraversal();
  int globalIndex = (int) (Math.random() * nodeList.size());
  Node<T> old = nodeList.get(globalIndex);

  if (old.isRoot()) {
    // If it is the root, we just replace the root.
    tree.setRoot(newNode);
  } else {
    // Otherwise, we need to find the local index to replace it.
    Node<T> parent = old.getParent();
    int localIndex = parent.getChildren().indexOf(old);
    parent.removeChildAt(localIndex);
    parent.addChildAt(localIndex, newNode);
  }
}