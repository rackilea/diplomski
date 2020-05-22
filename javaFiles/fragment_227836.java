@Override public Component getTreeCellRendererComponent(
    JTree tree, Object value, boolean selected, boolean expanded,
    boolean leaf, int row, boolean hasFocus) {
  Component renderer = delegate.getTreeCellRendererComponent(
    tree, value, selected, expanded, leaf, row, hasFocus);
  if (value instanceof DefaultMutableTreeNode) {
    Object userObject = ((DefaultMutableTreeNode) value).getUserObject();
    // Inside this if clause, those cells which do not require checkbox will be returned
    if(userObject instanceof String && ((String) userObject).startsWith("A")){
      return renderer;
    }
    //...