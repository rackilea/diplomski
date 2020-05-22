treeTable.addMouseListener(new MouseAdapter() {
    @Override
    public void mouseClicked(final MouseEvent e) {
        if (e.getClickCount() != 2) {
            return;
        }

        final int rowIndex = treeTable.rowAtPoint(e.getPoint());

        if (rowIndex < 0) {
            return;
        }

        final TreeTableNode selectedNode = (TreeTableNode)treeTable.getPathForRow(rowIndex).getLastPathComponent();
    }
});