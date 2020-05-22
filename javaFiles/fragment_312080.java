treeTable.addTreeWillExpandListener(new TreeWillExpandListener() {
    public void treeWillExpand(TreeExpansionEvent e)
            throws ExpandVetoException {
    }

    public void treeWillCollapse(TreeExpansionEvent e)
            throws ExpandVetoException {
        throw new ExpandVetoException(e);
    }
});