public class CustomBorderCellRenderer extends DefaultTableCellRenderer {
    private static final long serialVersionUID = 1L;

    private Color borderColor;

    public CustomBorderCellRenderer(Color borderColor) {
        this.borderColor = borderColor;
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        JComponent component = (JComponent) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        ((JLabel) component).setHorizontalAlignment(JLabel.CENTER);
        component.setBorder(BorderFactory.createLineBorder(borderColor));
        return component;
    }
}