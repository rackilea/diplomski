public static void main(String[] args)
{
    Display display = Display.getDefault();
    final Shell shell = new Shell(display);
    shell.setLayout(new FillLayout());

    final Table table = new Table(shell, SWT.NONE);
    table.setHeaderVisible(true);

    /* Create columns */
    for (int i = 0; i < 3; i++)
    {
        TableColumn col = new TableColumn(table, SWT.NONE);
        col.setText("Col " + i);
    }

    /* Create items */
    for (int i = 0; i < 10; i++)
    {
        TableItem item = new TableItem(table, SWT.NONE);
        item.setText(new String[] { "Row" + i + "Col1", "Row" + i + "Col2", "Row" + i + "Col3" });
    }

    /* Pack columns */
    for (int i = 0; i < 3; i++)
    {
        table.getColumn(i).pack();
    }

    table.addListener(SWT.MouseUp, new Listener()
    {
        @Override
        public void handleEvent(Event event)
        {
            Point pt = new Point(event.x, event.y);
            TableItem item = table.getItem(pt);
            if (item != null)
            {
                /* Iterate over all columns and check if event is contained */
                for (int col = 0; col < table.getColumnCount(); col++)
                {
                    Rectangle rect = item.getBounds(col);
                    if (rect.contains(pt))
                    {
                        System.out.println(item.getText(col));
                    }
                }
            }
        }
    });

    shell.pack();
    shell.open();
    while (!shell.isDisposed())
    {
        if (!display.readAndDispatch())
            display.sleep();
    }
    display.dispose();
}