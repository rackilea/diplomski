public Component getTableCellRendererComponent(JTable table, Object value, 
  boolean isSelected, boolean hasFocus,int row,int col) {
    if (isSplitted(value) {
        JPanel panel = new JPanel(new GridLayout(1,2));
        JLabel left = new JLabel(getLeft(value));
        JLabel right = new JLabel(getRight(value));        
        panel.add(left);
        panel.add(right);    
        return panel; 
      } else {
        return super.getTableCellRendererComponent(
           table, value, isSelected, hasFocus, row, col)
      }
}