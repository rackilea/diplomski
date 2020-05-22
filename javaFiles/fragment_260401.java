private class cellRenderer extends DefaultTableCellRenderer {
    Color originalColor = null;

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {

      Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);


       if (originalColor == null) {
           originalColor = cell.getBackground();
      }

      if(row==column){
          cell.setBackground(Color.yellow);
      } else {
          cell.setBackground(originalColor);
      }

      return cell;
    }
}