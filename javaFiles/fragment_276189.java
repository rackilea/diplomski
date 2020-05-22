check.addMouseListener(new MouseAdapter() {
  public void mouseClicked(MouseEvent ev) {
    checkNode.setSelected(check.isSelected());
    DefaultTreeModel dtm = (DefaultTreeModel)tree.getModel();
    dtm.nodeChanged(node);
  }
});