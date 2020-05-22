public Component getTableCellRendererComponent(JTable table, Object value,
    boolean isSelected, boolean hasFocus, int row, int column){   

    this.setOpaque(true);
    TableCellRenderer renderer = table.getTableHeader().getDefaultRenderer();
    return renderer.getTableCellRendererComponent(table, value, isSelected,
          hasFocus, row, column);
}