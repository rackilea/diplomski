JTable table = new JTable(dtm){
    @Override
    public TableCellEditor getCellEditor(int row, int column) {
        if(getValueAt(row, column) instanceof Boolean){
            return super.getDefaultEditor(Boolean.class);
        }
        return super.getCellEditor(row, column);
    }

    @Override
    public TableCellRenderer getCellRenderer(int row, int column) {
        if(getValueAt(row, column) instanceof Boolean){
            JCheckBox cb = (JCheckBox) getDefaultRenderer(Boolean.class);
            cb.setHorizontalAlignment(SwingConstants.LEFT);
            return getDefaultRenderer(Boolean.class);
        }

        return super.getCellRenderer(row, column);
    }
};

JCheckBox cb = new JCheckBox();
cb.setHorizontalAlignment(SwingConstants.LEFT);
TableCellEditor tce = new DefaultCellEditor(cb);        
table.setDefaultEditor(Boolean.class, tce);