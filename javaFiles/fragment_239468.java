public int closeness(Node x) {
  if (x.left == null) {
    if (x.right == null) {
      return 0;
    }
    return closedness(x.right) + 1;
  }
  if (x.right == null) {
    return closedness(x.left) + 1;
  }
  return Math.min(closeness(x.left), closeness(x.right)) + 1;
}