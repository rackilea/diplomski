public static TableCellRenderer createCellRenderer(final Vector data) {
    return new DefaultTableCellRenderer() {
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Component c =  super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

            // use data to customize current component

            return c;
        }
    };
}

public static void setCellRenderer(JTable table, Vector data) {
    // Vector data = ((DefaultTableModel) table.getModel()).getDataVector();
    TableCellRenderer cellRenderer = createCellRenderer(data);
    table.setDefaultRenderer(Object.class, cellRenderer);
}