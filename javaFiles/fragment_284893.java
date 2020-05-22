@Override
public void treeWillExpand(TreeExpansionEvent e) throws ExpandVetoException {
    CustomTreeNode t = (CustomTreeNode) e.getPath().getLastPathComponent();
    t.addChildLoadedListener(new ChildLoadedListener() {
        @Override
        public void childLoaded(TreeNode parent) {
            ((CustomTreeNode) parent).setExpanded(true);
            expandPath(new TreePath(((CustomTreeNode) parent).getPath()));
        }
    });
    if (!t.isExpanded()) {
        factory.loadChildren(t);
        throw new ExpandVetoException(null);
    }
}

public void treeWillCollapse(TreeExpansionEvent e) throws ExpandVetoException {
    CustomTreeNode t = (CustomTreeNode) e.getPath().getLastPathComponent();
    t.setExpanded(false);
}