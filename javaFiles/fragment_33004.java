// custom ColumnFactory to configure the columns
ColumnFactory factory = new ColumnFactory(){

    /** 
     * @inherited <p>
     */
    @Override
    public void configureTableColumn(TableModel model,
            TableColumnExt columnExt) {
        super.configureTableColumn(model, columnExt);
        columnExt.setResizable(columnExt.getModelIndex() < 2);
        if (columnExt.getModelIndex() >= 2) {
            columnExt.setPreferredWidth(50);
        } else {
            columnExt.setPreferredWidth(150);
        }
    }

    /** 
     * @inherited <p>
     * Overridden to do nothing
     */
    @Override
    public void configureColumnWidths(JXTable table,
            TableColumnExt columnExt) {
    }

};

final JXTable table = new JXTable();
table.setColumnFactory(factory);
table.setModel(new DefaultTableModel(20, 5));
// propertyChangeListener
PropertyChangeListener l = new PropertyChangeListener() {

    TableColumn first = table.getColumn(0);
    TableColumn second = table.getColumn(1);

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        TableColumn resizingColumn = (TableColumn) evt.getNewValue();
        if (resizingColumn == null) {
            TableColumn oldResizing = (TableColumn) evt.getOldValue();
            TableColumn other = oldResizing == first ? second : first;
            other.setMaxWidth(Integer.MAX_VALUE);
            other.setMinWidth(15);
        } else {
            TableColumn other = resizingColumn == first ? second : first;
            other.setMaxWidth(other.getPreferredWidth());
            other.setMinWidth(other.getPreferredWidth());
        }

    }
};

table.getTableHeader().addPropertyChangeListener("resizingColumn", l);