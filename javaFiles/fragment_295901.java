public Component getTableCellRendererComponent(JTable table, Object obj, 
    boolean isSelected,  boolean hasFocus, int row, int column) {
    Component cell = super.getTableCellRendererComponent(
      table, obj, isSelected, hasFocus, row, column);
    JPanel panel = new JPanel(new GridLayout(1, 2));
    if ("History".equals(obj)) {
        JTextField left = new JTextField("Left");
        left.setEditable(true);
        JTextField right = new JTextField("Right");
        left.setEditable(true);
        panel.add(left);
        panel.add(right);
        return panel;
    }
    return cell;
}