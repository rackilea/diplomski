private static Tree addNodeFixed(Tree tree, Label posTag, Label value, int index) {
  Tree posNode = new LabeledScoredTreeNode(posTag);
  posNode.setValue(posTag.value());
  Tree valueNode = new LabeledScoredTreeNode(value);
  valueNode.setValue(value.value());
  posNode.addChild(valueNode);

  tree.insertDtr(posNode, index);
  return tree;
}