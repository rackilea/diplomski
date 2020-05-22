private JTable getNewRenderedTable(final JTable table) {
    table.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int col) {
            Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, col);
            String status = (String)table.getModel().getValueAt(row, index);
            if (Constants.seller.equals(status)) {
                c.setBackground(Color.GRAY);
                //setForeground(Color.WHITE);
            } else {
                c.setBackground(table.getBackground());
                c.setForeground(table.getForeground());
            }       
            return c;
        }   
    });
    table.setDefaultRenderer(Number.class, table.getDefaultRenderer(Object.class));
    table.setDefaultRenderer(Double.class, table.getDefaultRenderer(Object.class));
    return table;
}