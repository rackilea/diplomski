class ColorComboBoxRenderer extends JLabel
        implements ListCellRenderer {

    public Component getListCellRendererComponent(
            JList list,
            Object value,
            int index,
            boolean isSelected,
            boolean cellHasFocus) {

        if (value instanceof Color) {
            Color color = (Color) value;

            if (color.equals(Color.red)) {
                setText("Red");
            } else if (color.equals(Color.green)) {
                setText("Green");
            }
        } else {
            setText(" ");
        }
        return this;
    }
}