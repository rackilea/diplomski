public int nonleaves() {
  int nonLeafCount = 0;
  BTNode<Integer> [] stack = new BTNode[2];
  int p = 0;
  stack[p++] = root; // push root
  while (p != 0) {
    BTNode<Integer> node = stack[--p]; // pop
    if (node.left != null || node.right != null) ++nonLeafCount;
    if (p + 1 >= stack.length) stack = Arrays.copyOf(stack, 2 * stack.length);
    if (node.right != null) stack[p++] = node.right; // push right
    if (node.left != null) stack[p++] = node.left;   // push left
  }
  return nonLeafCount;
}