public static void main(final String[] args)
{
    Display display = new Display();
    shell = new Shell(display);
    shell.setText("StackOverflow");
    shell.setLayout(new GridLayout(1, false));

    createToolbar();

    SashForm form = new SashForm(shell, SWT.VERTICAL);
    form.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
    createTablePart(form);
    createMessagesPart(form);
    form.setWeights(new int[] { 3, 1 });

    shell.pack();
    shell.open();
    shell.setSize(500, 350);
    while (!shell.isDisposed())
    {
        if (!display.readAndDispatch())
        {
            display.sleep();
        }
    }
    display.dispose();
}

private static void createToolbar()
{
    ToolBar toolbar = new ToolBar(shell, SWT.FLAT | SWT.BORDER | SWT.HORIZONTAL | SWT.RIGHT);
    toolbar.setLayoutData(new GridData(SWT.FILL, SWT.BEGINNING, true, false));

    String[] labels = new String[] { "A", "B", "C" };
    for (int i = 0; i < 3; i++)
    {
        ToolItem item = new ToolItem(toolbar, SWT.PUSH);
        item.setText(labels[i]);
    }
    toolbar.pack();
}

private static void createTablePart(SashForm parent)
{
    Table table = new Table(parent, SWT.BORDER);
    table.setHeaderVisible(true);
    table.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

    for (int col = 0; col < 3; col++)
    {
        TableColumn column = new TableColumn(table, SWT.NONE);
        column.setText("Col " + col);
    }

    for (int row = 0; row < 10; row++)
    {
        TableItem item = new TableItem(table, SWT.NONE);
        item.setText(0, row + " " + 0);
        item.setText(1, row + " " + 1);
        item.setText(2, row + " " + 2);
    }

    for (TableColumn col : table.getColumns())
        col.pack();
}

private static void createMessagesPart(SashForm parent)
{
    Text text = new Text(parent, SWT.BORDER | SWT.MULTI | SWT.V_SCROLL | SWT.WRAP);
    GridData data = new GridData(SWT.FILL, SWT.END, true, false);
    data.heightHint = 50;
    text.setLayoutData(data);

    text.setText("First Message\nSecond Message\nThirdMessage\nFourth Message");
}