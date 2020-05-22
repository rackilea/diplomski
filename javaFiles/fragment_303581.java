public static TableCellRenderer createCellRenderer() {
    return new DefaultTableCellRenderer() {
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component c =  super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

            c.setBackground(Color.GREEN);

            return c;
        }
    };
}

public static void setCellRenderer(JTable table) {
    TableCellRenderer cellRenderer = createCellRenderer();
    table.setDefaultRenderer(Object.class, cellRenderer);
}