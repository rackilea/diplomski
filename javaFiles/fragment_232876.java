public class ColorTableCellRenderer extends DefaultTableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {

        super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

        setText(null);
        if (value instanceof Color) {

            setOpaque(true);
            setBackground((Color)value);

        }

        return this;

    }

}