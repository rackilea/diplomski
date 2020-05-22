int count(Node node) {

  if (node == null)
      return 0;

  int r = count (node.right);
  int l = count (node.left);

  process(node);    

  return 1 + r + l;
}