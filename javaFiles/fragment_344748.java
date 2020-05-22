public static class SelectionMaintainer implements TreeSelectionListener {
  private final JTree tree1;
  private final JTree tree2;

  private boolean changing;

  public SelectionMaintainer(JTree tree1, JTree tree2) {
    this.tree1 = tree1;
    this.tree2 = tree2;
  }

  public valueChanged(TreeSelectionEvent e) {
    // Use boolean flag to guard against infinite loop caused by performing
    // a selection change in this method (resulting in another selection
    // event being fired).
    if (!changing) {
      changing = true;
      try {
        if (e.getSource == tree1) {
          tree2.clearSelection();
        } else {
          tree1.clearSelection();
        }
      } finally {
        changing = false;
      }
    }   
  }
}