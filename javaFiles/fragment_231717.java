public static int depth(Tree t) {
  return (t == null) ? 0 : calculateDepth(t) - 1;
}

private static int calculateDepth(Tree t) {
  if (t == null)
    return 0;
  else
    return 1 + Math.max(calculateDepth(t.left), calculateDepth(t.right));
}