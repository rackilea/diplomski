public int countLeaves() {
 return countLeaves(root);
 }

/**
 * Recursively count all nodes
 */
private static int countLeaves (Node<E> node) {
 if(node==null)
   return 0;

 if(node.left ==null && node.right == null)
  return 1;
 else {
    return countLeaves(node.left) + countLeaves(node.right);
   }
}