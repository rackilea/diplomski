public static class WrappingRenderer implements TableCellRenderer {

    private DefaultTableCellHeaderRenderer delegate;
    private JTableHeader header;

    public WrappingRenderer(JTableHeader header) {
        this.header = header;
        this.delegate = (DefaultTableCellHeaderRenderer) header.getDefaultRenderer();
        header.setDefaultRenderer(this);
    }

    @Override
    public Component getTableCellRendererComponent(JTable table,
            Object value, boolean isSelected, boolean hasFocus, int row,
            int column) {
        Component comp = delegate.getTableCellRendererComponent(table, 
                value, isSelected, hasFocus, row, column);
        TableColumn draggedColumn = table.getTableHeader().getDraggedColumn();
        if (draggedColumn != null) {
            if (table.convertColumnIndexToModel(column) == draggedColumn.getModelIndex()) {
                setNimbusState("Pressed");
            } else {
                setNimbusState(null);
            }

        } else {
            setNimbusState(null);
        }
        // do similar for resizing column
        return comp;
    }

    public void setNimbusState(String state) {
        delegate.putClientProperty("Nimbus.State", state);
    }
}