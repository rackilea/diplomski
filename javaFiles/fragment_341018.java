class ImageHeaderRenderer extends DefaultTableCellRenderer {
  JLabel label = new JLabel();

  ImageIcon icon = new ImageIcon(getClass().getResource("image.png"));

  public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
      boolean hasFocus, int row, int column) {
    label.setText("");
    label.setIcon(icon);
    return label;
  }
}