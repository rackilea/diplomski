JTable table = new JTable(tableModel);

Action action = new AbstractAction() {...};

ButtonColumn buttonColumn = new ButtonColumn(table, action, 5) {
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        JButton button = (JButton)super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        button.setContentAreaFilled(false);
        button.setBorder(BorderFactory.createEmptyBorder());
        // Customize the icon and whatever you want here
        return button;
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        JButton button = (JButton)super.getTableCellEditorComponent(table, value, isSelected, row, column);
        button.setContentAreaFilled(false);
        // Customize the icon and whatever you want here
        return button;
    }
};