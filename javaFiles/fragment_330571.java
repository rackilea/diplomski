Font f1 = cb.getFont();
Font f2 = new Font("Tahoma", 0, 14);

cb.setRenderer(new DefaultListCellRenderer() {
    @Override
    public Component getListCellRendererComponent(JList<?> list, Object value,
            int index, boolean isSelected, boolean cellHasFocus) {
        if (value instanceof JComponent)
            return (JComponent) value;

        boolean itemEnabled = !value.toString().startsWith("**"); 

        super.getListCellRendererComponent(list, value, index,
                isSelected && itemEnabled, cellHasFocus);

        // Render item as disabled and with different font:
        setEnabled(itemEnabled);
        setFont(itemEnabled ? f1 : f2);

        return this;
    }
});