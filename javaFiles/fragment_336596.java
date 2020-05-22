final Table table = new Table(shell, SWT.BORDER | SWT.V_SCROLL | SWT.FULL_SELECTION);
table.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
table.setHeaderVisible(true);
table.setLinesVisible(true);

final TableColumn column1 = new TableColumn(table, SWT.NONE);
column1.setText("Column 1");
column1.setWidth(75);

final TableColumn column2 = new TableColumn(table, SWT.NONE);
column2.setText("Column 2");
column2.setWidth(75);

final TableColumn column3 = new TableColumn(table, SWT.CENTER);
column3.setText("Column 3");
column3.setWidth(75);

for (int i = 0; i < 5; i++) {
    new TableItem(table, SWT.CENTER).setText(new String[] { "a", "b", "c" });
}