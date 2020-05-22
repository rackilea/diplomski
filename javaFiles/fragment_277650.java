jTable1 = new JTable(dm) {
    protected JTableHeader createDefaultTableHeader() {
        return new GroupableTableHeader(columnModel);
    }
};

jScrollPane1.setViewportView(jTable1);