public void fireTreeInsert(TreePath path, Object child) {
      Object[] children = {child};
      int index = this.getIndexOfChild(path.getLastPathComponent(), child);
      int[] indicies = {index};
      TreeModelEvent e = new TreeModelEvent(this, path, indicies, children);
      EventListener[] listeners = mTreeModel.getListeners(TreeModelListener.class);
      for (int ii = 0; ii < listeners.length; ii++) {
         ((TreeModelListener)listeners[ii]).treeNodesInserted(e);
      }
   }