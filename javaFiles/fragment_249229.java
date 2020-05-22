final TableCellRenderer r = table.getTableHeader().getDefaultRenderer();
TableCellRenderer wrapper = new TableCellRenderer() {

    @Override
    public Component getTableCellRendererComponent(JTable table,
            Object value, boolean isSelected, boolean hasFocus,
            int row, int column) {
        Component comp = r.getTableCellRendererComponent(table, value, isSelected, 
            hasFocus, row, column);
        if (comp instanceof JLabel) {
            JLabel label = (JLabel) comp;
            label.setIcon(getSortIcon(table, column));
        }
        return comp;
    }

    /**
     * Implements the logic to choose the appropriate icon.
     */
    private Icon getSortIcon(JTable table, int column) {
        SortOrder sortOrder = getColumnSortOrder(table, column);
        if (SortOrder.UNSORTED == sortOrder) {
            return null;
        }
        return SortOrder.ASCENDING == sortOrder ? ascendingIcon : descendingIcon;
    }

    private SortOrder getColumnSortOrder(JTable table, int column) {
        if (table == null || table.getRowSorter() == null) {
            return SortOrder.UNSORTED;
        }
        List<? extends SortKey> keys = table.getRowSorter().getSortKeys();
        if (keys.size() > 0) {
            SortKey key = keys.get(0);
            if (key.getColumn() == table.convertColumnIndexToModel(column)) {
                return key.getSortOrder();
            }
        }
        return SortOrder.UNSORTED;
    }

};
table.getTableHeader().setDefaultRenderer(wrapper);