jScrollPane1.setViewportView(jTable1);

jTable1 = new JTable(dm) {
    protected JTableHeader createDefaultTableHeader() {
        return new GroupableTableHeader(columnModel);
    }
};