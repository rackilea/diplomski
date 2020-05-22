public static void main(String[] args)
{
    final Display display = new Display();
    Shell shell = new Shell(display);
    shell.setText("StackOverflow");
    shell.setLayout(new FillLayout());

    // If you choose to create a Color instance yourself, remember to dispose() it!
    final Color highlight = display.getSystemColor(SWT.COLOR_YELLOW);

    final Table table = new Table(shell, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL | SWT.FULL_SELECTION | SWT.BORDER);

    table.addListener(SWT.EraseItem, new Listener()
    {
        public void handleEvent(Event event)
        {
            event.detail &= ~SWT.HOT;
            if ((event.detail & SWT.SELECTED) == 0)
                return; // / item not selected

            Table table = (Table) event.widget;
            int clientWidth = table.getClientArea().width;

            GC gc = event.gc;
            Color oldForeground = gc.getForeground();
            Color oldBackground = gc.getBackground();

            gc.setBackground(highlight);
            gc.fillRectangle(0, event.y, clientWidth, event.height);

            gc.setForeground(oldForeground);
            gc.setBackground(oldBackground);
            event.detail &= ~SWT.SELECTED;
        }
    });

    final TableColumn column = new TableColumn(table, SWT.NONE);

    table.addListener(SWT.Resize, new Listener()
    {
        @Override
        public void handleEvent(Event event)
        {
            column.setWidth(table.getClientArea().width);
        }
    });

    for (int i = 0; i < 10; i++)
        new TableItem(table, SWT.NONE).setText(Integer.toString(i));

    shell.pack();
    shell.open();

    while (!shell.isDisposed())
    {
        if (!display.readAndDispatch())
        {
            display.sleep();
        }
    }
    display.dispose();
}