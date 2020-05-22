// either subclass
JTable table = new JTable(new AncientSwingTeam()) {

    @Override
    protected JTableHeader createDefaultTableHeader() {
        return new MyTableHeader(getColumnModel());
    }

};
table.setAutoCreateRowSorter(true);