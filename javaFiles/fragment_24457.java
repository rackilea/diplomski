// a custom factory
ColumnFactory factory = new ColumnFactory() {

    @Override
    protected int calcPrototypeWidth(JXTable table,
            TableColumnExt columnExt) {
        if (isHierarchicalPrototype(table, columnExt))  {
            return calcHierarchicalPrototypeWidth((JXTreeTable) table, columnExt);
        }
        return super.calcPrototypeWidth(table, columnExt);
    }

    protected boolean isHierarchicalPrototype(JXTable table,
            TableColumnExt columnExt) {
        return (table instanceof JXTreeTable) 
                && ((JXTreeTable) table).getTreeTableModel().getHierarchicalColumn() == 
                         columnExt.getModelIndex()
                && columnExt.getPrototypeValue() != null;
    }

    TreeCellRenderer dummy = new DefaultTreeCellRenderer();
    protected int calcHierarchicalPrototypeWidth(JXTreeTable table,
            TableColumnExt columnExt) {
        JXTree renderer = (JXTree) getCellRenderer(table, columnExt);
        // commented lines would be the obvious step down into the "real" sizing
        // requirements, but giving reasonable result due to internal black magic
        // TreeCellRenderer treeRenderer = renderer.getCellRenderer();
        // Component comp = treeRenderer.getTreeCellRendererComponent(renderer, 
              columnExt.getPrototypeValue(), false, false, false, -1, false);
        // instead, measure a dummy
        Component comp = dummy.getTreeCellRendererComponent(renderer, 
                columnExt.getPrototypeValue(), false, false, false, -1, false);

        return Math.max(renderer.getPreferredSize().width, comp.getPreferredSize().width);
    }

};

// usage: first create the treeTable, set the factory and set the model
JXTreeTable table = new JXTreeTable();
table.setColumnFactory(factory);
table.setTreeTableModel(new FileSystemModel());
// set the prototype
table.getColumnExt(0).setPrototypeValue("long longer longest still not enough to really see" +
           " some effect of the prototype if available");
// Issue #1510: prototype value handling broken in underlying JXTable
// need to manually force the config
table.getColumnFactory().configureColumnWidths(table, table.getColumnExt(0));