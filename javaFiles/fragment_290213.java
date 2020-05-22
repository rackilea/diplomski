public static class ScrollLock {
    private JXTable table;
    private boolean blocked;
    private int rowsBelow;

    public ScrollLock(JXTable table) {
        this.table = table;
        table.getModel().addTableModelListener(getTableModelListener());
    }

    private TableModelListener getTableModelListener() {
        TableModelListener l = new TableModelListener() {

            @Override
            public void tableChanged(TableModelEvent e) {
                if (!blocked) return;
                if (e.getType() == TableModelEvent.INSERT) {
                    updateInsert(e.getFirstRow(), e.getLastRow());
                }
            }

        };
        return l;
    }

    protected void updateInsert(int firstRow, int lastRow) {
        // PENDING: assumption is that insert always above
        // need additional logic for other cases
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Rectangle r = table.getVisibleRect();
                int row =table.rowAtPoint(new Point(0, r.y + r.height));
                int lastVisible = table.getRowCount() - rowsBelow;
                table.scrollRowToVisible(lastVisible);
            }
        });
    }

    public void block() {
        Rectangle viewRect = table.getVisibleRect();
        int lastVisibleRow = table.rowAtPoint(new Point(0, viewRect.y + viewRect.height));
        rowsBelow = table.getRowCount() - lastVisibleRow;
        blocked = true;
    }

    public void unblock() {
        blocked = false;
        rowsBelow = -1;
    }

}