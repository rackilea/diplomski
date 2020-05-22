private JScrollPane getTablePane() {
    if (tablePane == null) {
        tablePane = new JScrollPane();
        tablePane.setRowHeaderView(getTableDictionary());
        tablePane.setViewportView(getTableDictionary());
        tablePane.setColumnHeader(new JViewport() {
        @Override public Dimension getPreferredSize() {
            Dimension d = super.getPreferredSize();
            d.height = rowColumnHeigth;  // Col header Height
            return d;
            }
        });
    }
    return tablePane;
}