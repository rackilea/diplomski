public int nonleaves() {
  int nonLeafCount = 0;
  BTNode<Integer>[] stack = new BTNode[1];
  int p = 0;
  BTNode<Integer> node = root;
  for (;;) {
    if (node.left == null) {
      if (node.right == null) {
        if (p == 0) break;
        node = stack[--p];
      } else { // node.right != null
        ++nonLeafCount;
        node = node.right;
      }
    } else { // node.left != null
      ++nonLeafCount;
      if (node.right != null) {
        if (p >= stack.length) {
          stack = Arrays.copyOf(stack, 2 * stack.length);
        }
        stack[p++] = node.right;
      }
      node = node.left;
    }
  }
  return nonLeafCount;
}