public class JIDCellEditor extends AbstractCellEditor implements TableCellEditor {

    private JComboBox jComboBox = new JComboBox();
    boolean cellEditingStopped = false;

    @Override
    public Object getCellEditorValue() {
        return jComboBox.getSelectedItem();
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        Vector vector = new Vector();
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        arrayList.add(Integer.parseInt(value.toString()));
        vector.add(0);
        for (int i = 0; i < table.getRowCount(); i++) {
            if (!vector.contains(table.getValueAt(i, 0)) && table.getValueAt(i, 3).toString().equals("Sheep")) {
                vector.add(table.getValueAt(i, 0));
            }
        }
        vector.remove(table.getValueAt(row, 0));

        for (int i = 0; i < vector.size(); i++) {
        }
        jComboBox = new JComboBox(vector);
        jComboBox.setSelectedItem(value);

        jComboBox.addItemListener(new ItemListener() {

            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    fireEditingStopped();
                }
            }
        });
        jComboBox.addPopupMenuListener(new PopupMenuListener() {

            @Override
            public void popupMenuWillBecomeVisible(PopupMenuEvent e) {
                cellEditingStopped = false;
            }

            @Override
            public void popupMenuWillBecomeInvisible(PopupMenuEvent e) {
                cellEditingStopped = true;
                fireEditingCanceled();
            }

            @Override
            public void popupMenuCanceled(PopupMenuEvent e) {

            }
        });
        return jComboBox;
    }

    @Override
    public boolean stopCellEditing() {
        return cellEditingStopped;
    }
}