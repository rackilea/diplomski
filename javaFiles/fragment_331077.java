public static void main(String[] args)
{
    final Display display = new Display();
    Shell shell = new Shell(display);
    shell.setText("StackOverflow");
    shell.setLayout(new FillLayout());

    final Table table = new Table(shell, SWT.NONE);

    for (int i = 0; i < 100; i++)
    {
        TableItem item = new TableItem(table, SWT.NONE);
        item.setText("Item " + i);
    }

    table.addListener(SWT.MouseWheel, new Listener()
    {
        @Override
        public void handleEvent(Event e)
        {
            e.doit = false;
            if (e.count >= 0)
                table.setTopIndex(table.getTopIndex() - 1);
            else
                table.setTopIndex(table.getTopIndex() + 1);
        }
    });

    shell.pack();
    shell.setSize(shell.getSize().x, 300);
    shell.open();

    while (!shell.isDisposed())
    {
        if (!display.readAndDispatch())
            display.sleep();
    }
    display.dispose();
}