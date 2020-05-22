JComboBox cb = new JComboBox();
DefaultCellEditor editor = new DefaultCellEditor(cb) {

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        JComboBox editor = (JComboBox) getComponent();
        String[] listItems = new String[arrayList.getSize()];
        int i = -1;
        for (String s : arrayList) {
            i++;
            listItems[i] = s;
        }

        DefaultComboBoxModel model = new DefaultComboBoxModel(listItems);
        editor.setModel(model);
        editor.setSelectedItem(value);
        return editor;
    }
};

JTable table = new JTable(new DefaultTableModel(5, 1));
table.getColumnModel().getColumn(0).setCellEditor(editor);