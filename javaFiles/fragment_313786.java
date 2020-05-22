/**
 * Ensure the next call to rowClickSelect() will have no effect.
 */
private void skipNextRowClick() {
    this.skipNextClickSelect = true;
}

private void rowClickSelect(final TreeNode node) {
    if (this.skipNextClickSelect) {
        this.skipNextClickSelect = false;
        return;
    }
    // select on click row
    final boolean isSelected = Log4jPanel.this.treeTable.getTreeState().isNodeSelected(node);
    treeTable.getTreeState().selectNode(node, !isSelected);
}