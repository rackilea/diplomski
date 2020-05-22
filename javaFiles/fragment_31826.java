public static void main(String[] args)
{
    Display display = new Display();
    final Shell shell = new Shell(display);
    shell.setLayout(new GridLayout(1, false));

    Table table = new Table(shell, SWT.BORDER | SWT.SINGLE | SWT.FULL_SELECTION);
    table.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
    table.setLinesVisible(false);
    new TableColumn(table, SWT.RIGHT);
    new TableColumn(table, SWT.NONE);

    for (int row = 0; row < 20; row++)
    {
        TableItem item = new TableItem(table, SWT.NONE);
        item.setText(0, row + "");
        item.setText(1, "Item " + row);
    }

    for(int col = 0; col < table.getColumnCount(); col++)
    {
        table.getColumn(col).pack();
    }

    shell.pack();
    shell.open();
    while (!shell.isDisposed())
    {
        if (!display.readAndDispatch())
            display.sleep();
    }
    display.dispose();
}