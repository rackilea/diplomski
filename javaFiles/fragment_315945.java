DefaultMutableTreeNode findById(TreeModel treeModel, Long id) {
  if (id == 0) {
    return (DefaultMutableTreeNode) treeModel.getRoot();
  }
  String curveId = "curve " + id;
  // The enumeration returns all the nodes, so it's not necessary to do a recursive search 
  Enumeration en = ((DefaultMutableTreeNode) treeModel.getRoot()).breadthFirstEnumeration();
  while (en.hasMoreElements()) {
    DefaultMutableTreeNode node = (DefaultMutableTreeNode) en.nextElement();
    if (curveId.equalsIgnoreCase(node.toString()) {
      return node;
    }
  }   
}
void removeById(DefaultTreeModel treeModel, Long id) {
  DefaultMutableTreeNode nodeToRemove = findById(treeModel, id);
  if (nodeToRemove != null) {
    if (nodeToRemove.isRoot()) {
      nodeToRemove.removeAllChildren();
      treeModel.nodeStructuredChanged(nodeToRemove); // To notify the JTree to update from the root
    }
    else {
      treeModel.removeNodeFromParent(nodeToRemove); // Automatically notify the JTree
    }
  }
}