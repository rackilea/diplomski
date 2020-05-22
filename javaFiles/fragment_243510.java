class MyModel implements TableModel {
    private final TableModel m;
    public MyModel(TableModel m) {
        this.m = m;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        // This is how we disable editing:
        return false;
    }

    // The rest of the methods just forward to the other model:

    @Override
    public int getRowCount() {
        return m.getRowCount();
    }

    @Override
    public int getColumnCount() {
        return m.getColumnCount();
    }

    // ...and all other methods which I omit here...
}