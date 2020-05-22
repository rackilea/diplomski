private void updateRowHeights(JTable table ) {
    for (int row = 0; row < table.getRowCount(); row++) {
        int rowHeight = table.getRowHeight();
        for (int column = 0; column < table.getColumnCount(); column++) {
            Component comp = table.prepareRenderer(table.getCellRenderer(row, column), row, column);
            rowHeight = Math.max(rowHeight,comp.getPreferredSize().height);
        }
        table.setRowHeight(row, rowHeight);
    }
}