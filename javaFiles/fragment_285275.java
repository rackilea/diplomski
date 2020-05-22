public static class ButtonDialogEditor extends AbstractCellEditor 
     implements TableCellEditor {
    // the columns to present for editing, in model coordinates
    public final int lastColumn;
    public final int firstColumn;
    // the row to present for editing, in model coordinates
    private int row;

    private DefaultTableModel model;
    private JDialog dialog;
    private boolean committed;
    private JButton editingComponent;

    public ButtonDialogEditor(int firstColumn, int lastColumn) {
       this.firstColumn = firstColumn;
       this.lastColumn = lastColumn;

       model = new DefaultTableModel(1, lastColumn - firstColumn + 1);
       JTable table = new JTable(model);
       table.putClientProperty("terminateEditOnFocusLost",true);
       dialog = new JDialog();
       dialog.setModal(true);
       dialog.add(new JScrollPane(table));
       dialog.add(new JButton(createOkAction()), BorderLayout.SOUTH);
       dialog.pack();
       editingComponent = new JButton(createShowDialogAction());
    }

    /**
     * Returns the cell value at column. Note that column
     * is in the model coordinate system of the source model.
     */
    public Object getValueAt(int column) {
        return model.getValueAt(0, column - firstColumn);
    }

    /**
     * Returns the row index of the edited row in 
     * model coordinates of the source table.
     */
    public int getModelRow() {
        return row;
    }

    /**
     * Creates and returns the action used for 
     * the editing component button.
     * 
     * Implemented to show the modal dialog and fire 
     * editingSotpped/canceled depending on the committed
     * flag
     */
    private Action createShowDialogAction() {
        Action action = new AbstractAction() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // reset committed
                committed = false;
                dialog.setVisible(true);
                if (committed) {
                    fireEditingStopped();
                } else {
                    fireEditingCanceled();
                }
            }
        };
        return action;
    }

    /**
     * Creates and returns the action used for the dialog's
     * OK button.
     * 
     * Implemented to hide the dialog and set the
     * committed flag to true.
     */
    private Action createOkAction() {
        Action action = new AbstractAction("OK") {
            @Override
            public void actionPerformed(ActionEvent e) {
                dialog.setVisible(false);
                committed = true;
            }
        };
        return action;
    }

    @Override
    public Component getTableCellEditorComponent(JTable table,
            Object value, boolean isSelected, int row, int column) {
        editingComponent.setText(value != null ? value.toString() : "");
        prepareDialog(table, row);
        return editingComponent;
    }

    /**
     * Update internal state to the row to edit. 
     */
    private void prepareDialog(JTable table, int row) {
        this.row = table.convertRowIndexToModel(row);
        for (int i = firstColumn; i <= lastColumn; i++) {
            model.setValueAt(table.getModel().getValueAt(this.row, i), 0, i - firstColumn);
        }
    }

    /**
     * Implemented to return the original value as 
     * given in the 
     */
    @Override
    public Object getCellEditorValue() {
        return editingComponent.getText();
    }

}

public static class ButtonRenderer implements TableCellRenderer {

    JButton button = new JButton();
    @Override
    public Component getTableCellRendererComponent(JTable table,
            Object value, boolean isSelected, boolean hasFocus, int row,
            int column) {
        button.setText(value != null ? value.toString() : "");
        return button;
    }
}

// example usage
// source model is not editable except for the button column
final DefaultTableModel model = new DefaultTableModel(0, 3) {
    @Override
    public boolean isCellEditable(int row, int column) {
        return column == 0;
    }
};
for (int i = 0; i < 20; i++) {
    model.addRow(new Object[] {"Edit", i});
}
JTable table = new JTable(model);
table.getColumnModel().getColumn(0).setCellRenderer(new ButtonRenderer());
final ButtonDialogEditor cellEditor = new ButtonDialogEditor(1, model.getColumnCount() - 1);
// custom editor listener which writes back the edited values
// to the model on editingStopped.
CellEditorListener l = new CellEditorListener() {

    @Override
    public void editingStopped(ChangeEvent e) {
        for (int i = cellEditor.firstColumn; i <= cellEditor.lastColumn; i++) {
            model.setValueAt(cellEditor.getValueAt(i), cellEditor.getModelRow(), i);
        }
    }

    @Override
    public void editingCanceled(ChangeEvent e) {
        // nothing to do
    }
};
cellEditor.addCellEditorListener(l);
table.getColumnModel().getColumn(0).setCellEditor(
        cellEditor);