public static void main(String[] args)
{
    Display display = new Display();
    Shell shell = new Shell(display);
    shell.setText("StackOverflow");
    shell.setLayout(new FillLayout());

    ScrolledComposite comp = new ScrolledComposite(shell, SWT.V_SCROLL | SWT.H_SCROLL | SWT.BORDER);
    comp.setLayout(new FillLayout());

    final Table table = new Table(comp, SWT.BORDER | SWT.FULL_SELECTION);
    table.setHeaderVisible(true);
    table.setLinesVisible(true);
    for (int i = 0; i < 4; i++)
    {
        TableColumn column = new TableColumn(table, SWT.NONE);
        column.setText("Column " + i);
    }
    for (int i = 0; i < 64; i++)
    {
        TableItem item = new TableItem(table, SWT.NONE);
        for (int j = 0; j < table.getColumnCount(); j++)
        {
            item.setText(j, "Item " + i + "-" + j);
        }
    }
    for (int i = 0; i < table.getColumnCount(); i++)
    {
        table.getColumn(i).pack();
    }
    table.addListener(SWT.MouseDown, new Listener()
    {
        public void handleEvent(Event event)
        {
            Point pt = new Point(event.x, event.y);
            TableItem item = table.getItem(pt);
            if (item == null)
                return;
            for (int i = 0; i < table.getColumnCount(); i++)
            {
                Rectangle rect = item.getBounds(i);
                if (rect.contains(pt))
                {
                    int index = table.indexOf(item);
                    System.out.println("Item " + index + "-" + i);
                }
            }
        }
    });

    comp.setContent(table);
    comp.setExpandHorizontal(true);
    comp.setExpandVertical(true);
    comp.setMinSize(table.computeSize(SWT.DEFAULT, SWT.DEFAULT));

    shell.pack();
    shell.setSize(400, 600);
    shell.open();

    while (!shell.isDisposed())
    {
        if (!display.readAndDispatch())
            display.sleep();
    }
    display.dispose();
}