TableViewer tableViewer = new TableViewer(parent); 

Table table = tableViewer.getTable(); 
table.setHeaderVisible(true);      
table.setLinesVisible(true);`

for (int i = 0; i < COLUMN_NAMES.length; i++) {
    TableColumn tableColumn = new TableColumn(table, SWT.LEFT);
    tableColumn.setText(COLUMN_NAMES[i]);
    tableColumn.setWidth(COLUMN_WIDTHS[i]);
}

tableViewer.setContentProvider(new ModelContentProvider());
tableViewer.setLabelProvider(new ModelLabelProvider());
tableViewer.setInput(models);