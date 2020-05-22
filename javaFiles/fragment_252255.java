class PersonaTableModel extends AbstractTableModel {
    ...
    private boolean editable = true;

    public boolean isEditable() {
        return editable;
    }

    public boolean isCellEditable(int row, int column) {
        return editable;
    }

    public void setEditable(boolean editable) {
        this.editable = editable;
        fireTableDataChanged();
    }
    ...
}