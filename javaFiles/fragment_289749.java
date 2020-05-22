void traverse(node, depth) {
  print(node.value, depth);
  depth++;
  traverse(node.leftChild, depth);
  traverse(node.rightChild, depth);
  depth--;
}