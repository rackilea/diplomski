FilteredTree ft = new FilteredTree(composite, SWT.FULL_SELECTION, p, true) {
    @Override
    protected void updateToolbar(boolean visible) {
        super.updateToolbar(visible);
        treeViewer.expandAll();
    }
};