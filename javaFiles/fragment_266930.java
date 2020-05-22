tree.getModel().addTreeModelListener(new TreeModelListener() {
  @Override public void treeNodesChanged(TreeModelEvent e) {
    Object[] children = e.getChildren();
    if (children != null && children.length == 1
        && children[0] instanceof DefaultMutableTreeNode) {
      DefaultMutableTreeNode node = (DefaultMutableTreeNode) children[0];
      Object userObject = node.getUserObject();
      if (userObject instanceof Node) {
        Node uo = (Node) userObject;
        System.out.format(
            "%s %s%n", uo, uo.getPlugins()[uo.getSelectedPluginIndex()]);
      }
    }
  }
  @Override public void treeNodesInserted(TreeModelEvent e)  {}
  @Override public void treeNodesRemoved(TreeModelEvent e)   {}
  @Override public void treeStructureChanged(TreeModelEvent e) {}
});