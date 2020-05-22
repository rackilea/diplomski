class ProgRenderer extends JProgressBar implements 

TableCellRenderer {
   public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
      this.setValue((Integer)value)
      return this;
   }
}