public static void main(String[] args)
{
    final Display display = new Display();
    final Shell shell = new Shell(display);
    shell.setText("StackOverflow");
    shell.setLayout(new GridLayout());

    createMasterPart(shell);

    shell.pack();
    shell.setSize(400, 300);
    shell.open();

    shell.layout(true, true);

    while (!shell.isDisposed())
    {
        if (!display.readAndDispatch())
            display.sleep();
    }
    display.dispose();
}

private static void createMasterPart(Composite parentComposite)
{
    Composite composite = new Composite(parentComposite, SWT.NONE);
    composite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
    composite.setLayout(new GridLayout(1, false));

    Composite tableComposite = new Composite(composite, SWT.NONE);
    TableColumnLayout tableColumnLayout = new TableColumnLayout();
    tableComposite.setLayout(tableColumnLayout);
    tableComposite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

    TableViewer tableViewer = new TableViewer(tableComposite, SWT.BORDER | SWT.FULL_SELECTION);
    tableViewer.setContentProvider(ArrayContentProvider.getInstance());
    Table table = tableViewer.getTable();
    table.setHeaderVisible(true);
    table.setLinesVisible(true);

    TableViewerColumn firstTableViewerColumn = new TableViewerColumn(tableViewer, SWT.NONE);
    TableColumn firstTableColumn = firstTableViewerColumn.getColumn();
    firstTableColumn.setText("Sample");
    firstTableViewerColumn.setLabelProvider(new ColumnLabelProvider()
    {
        @Override
        public String getText(Object element)
        {
            Dummy p = (Dummy) element;
            return p.first;
        }
    });

    TableViewerColumn secondTableViewerColumn = new TableViewerColumn(tableViewer, SWT.NONE);
    TableColumn secondTableColumn = secondTableViewerColumn.getColumn();
    secondTableColumn.setText("Speaker");
    secondTableViewerColumn.setLabelProvider(new ColumnLabelProvider()
    {
        @Override
        public String getText(Object element)
        {
            Dummy p = (Dummy) element;
            return p.second;
        }
    });

    TableViewerColumn thirdTableViewerColumn = new TableViewerColumn(tableViewer, SWT.NONE);
    TableColumn thirdTableColumn = thirdTableViewerColumn.getColumn();
    thirdTableColumn.setText("Remark");
    thirdTableViewerColumn.setLabelProvider(new ColumnLabelProvider()
    {
        @Override
        public String getText(Object element)
        {
            Dummy p = (Dummy) element;
            return p.third;
        }
    });

    List<Dummy> elements = new ArrayList<>();

    for(int i = 0; i < 20; i++)
    {
        elements.add(new Dummy("firstfirstfirst " + i, "secondsecondsecond " + i, "thirdthirdthirdthirdthirdthird " + i));
    }

    tableViewer.setInput(elements);

    tableColumnLayout.setColumnData(firstTableColumn, new ColumnWeightData(1, true));
    tableColumnLayout.setColumnData(secondTableColumn, new ColumnWeightData(1, true));
    tableColumnLayout.setColumnData(thirdTableColumn, new ColumnWeightData(2, true));
}

private static class Dummy
{
    public String first;
    public String second;
    public String third;

    public Dummy(String first, String second, String third)
    {
        this.first = first;
        this.second = second;
        this.third = third;
    }
}