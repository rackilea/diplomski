int count(Node node) {

  if (node == null)
      return 0;

  process(node);    

  int r = count (node.right);
  int l = count (node.left);

  return 1 + r + l;
}