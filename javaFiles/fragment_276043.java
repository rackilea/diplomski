class ComboBoxRenderer extends JComboBox implements TableCellRenderer {

        public ComboBoxRenderer(Object[] items) {
        super(items);
    }

    private static final long serialVersionUID = 1L;



    @Override
    public Component getTableCellRendererComponent(JTable table, Object value,
        boolean isSelected, boolean hasFocus, int row, int column) {
        if (isSelected) {
            setForeground(table.getSelectionForeground());
            super.setBackground(table.getSelectionBackground());
        } else {
            setForeground(table.getForeground());
            setBackground(table.getBackground());
        }
        // Select the current value
        setSelectedItem(value);
        return this;
    }
    }