table = new JTable(data, colNames) {
    private static final long serialVersionUID = 1L;

    public void tableChanged(TableModelEvent e) {
        super.tableChanged(e);
        int column = e.getColumn();
        assert e.getFirstRow() == e.getLastRow() : "more than 1 row have been changed!";
        int row = e.getFirstRow();
        if (scrollPane != null) {
            //some codes
        }
    }
};