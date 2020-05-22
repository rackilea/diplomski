public int maxDepth() {
  int max = 0;
  Pair<Integer> [] stack = new Pair[2];
  int p = 0;
  stack[p++] = new Pair(root, 1);
  while (p != 0) {
    Pair<Integer> pair = stack[--p];
    if (pair.depth > max) max = pair.depth;
    if (p + 1 >= stack.length) stack = Arrays.copyOf(stack, 2 * stack.length);
    if (pair.node.right != null) 
      stack[p++] = new Pair(pair.node.right, 1 + pair.depth);
    if (pair.node.left != null) 
      stack[p++] = new Pair(pair.node.left, 1 + pair.depth);
  }
  return max;
}

private static class Pair<T> {
  BTNode<T> node;
  int depth;
  Pair(BTNode<T> node, int depth) {
    this.node = node;
    this.depth = depth;
  }
}