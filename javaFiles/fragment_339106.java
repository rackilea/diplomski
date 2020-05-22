private final TableModel model = new DefaultTableModel(data, columnNames) {

    @Override
    public Class<?> getColumnClass(int column) {
        switch (column) {
             …
        }
    }
};