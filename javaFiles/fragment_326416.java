static class RowHeaderRenderer extends DefaultTableCellRenderer {
    public RowHeaderRenderer() {
        setHorizontalAlignment(JLabel.CENTER);
    }

    public Component getTableCellRendererComponent(JTable table,
            Object value, boolean isSelected, boolean hasFocus, int row,
            int column) {
        if (table != null) {
            JTableHeader header = table.getTableHeader();

            if (header != null) {
                setForeground(header.getForeground());
                setBackground(header.getBackground());
                setFont(header.getFont());
            }
        }

        if (isSelected) {
            setFont(getFont().deriveFont(Font.BOLD));
        }

        setValue(value);
        return this;
    }
}