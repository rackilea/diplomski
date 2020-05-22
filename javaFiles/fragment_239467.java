public int closeness(Node x) {
  if (x == null) {
    return Integer.MAX_VALUE;
  }
  if (x.left == null && x.right == null) {
    return 0;
  }
  return Math.min(closeness(x.left), closeness(x.right)) + 1;
}