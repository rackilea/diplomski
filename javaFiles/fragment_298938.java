obj.table.setDefaultRenderer(Double.class, 
    new DefaultTableCellRenderer() { 
        @Override public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) { 
            if (value instanceof Number) {
                value = NumberFormat.getNumberInstance().format(value);
            }
            super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column); 
            setOpaque(isSelected); 
            return this; 
        } 
    });