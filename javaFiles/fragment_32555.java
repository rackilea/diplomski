private static Map<TableColumn, Integer> mapping = new HashMap<TableColumn, Integer>();

public static void main(String[] args)
{
    Display display = new Display();
    final Shell shell = new Shell(display);
    shell.setText("StackOverflow");
    shell.setLayout(new FillLayout());

    Listener listener = new Listener()
    {
        @Override
        public void handleEvent(Event arg0)
        {
            TableColumn column = (TableColumn) arg0.widget;

            System.out.println(mapping.get(column));
        }
    };

    Table table = new Table(shell, SWT.NONE);
    table.setHeaderVisible(true);

    for(int i = 0; i < 5; i++)
    {
        TableColumn column = new TableColumn(table, SWT.NONE);
        column.setText("Column " + i);
        column.addListener(SWT.Selection, listener);
        column.pack();

        mapping.put(column, i);
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