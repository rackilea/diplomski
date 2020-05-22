private void scrollPathToVisible(TreePath treePath) {
    if (treePath != null) {
        tree.makeVisible(treePath);

        Rectangle bounds = tree.getPathBounds(treePath);

        if (bounds != null) {
            bounds.x = 0;
            tree.scrollRectToVisible(bounds);
        }
    }
}