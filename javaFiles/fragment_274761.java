private static Map<String, Integer> COLOR_MAPPING = new HashMap<>();

static
{
    COLOR_MAPPING.put("red", SWT.COLOR_RED);
    COLOR_MAPPING.put("blue", SWT.COLOR_BLUE);
}

public static void main(String[] args)
{
    Display display = new Display();
    Shell shell = new Shell(display);
    shell.setText("StackOverflow");
    shell.setLayout(new GridLayout(1, false));

    TableViewer viewer = new TableViewer(shell, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL | SWT.FULL_SELECTION | SWT.BORDER);

    createColumns(viewer);

    final Table table = viewer.getTable();
    table.setHeaderVisible(true);
    table.setLinesVisible(true);

    List<MyObject> data = new ArrayList<>();
    data.add(new MyObject("Something", "red"));
    data.add(new MyObject("Something else", "blue"));
    data.add(new MyObject("Something else entirely", "bleen"));

    viewer.setContentProvider(ArrayContentProvider.getInstance());
    viewer.setInput(data);

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

private static void createColumns(TableViewer viewer)
{
    TableViewerColumn first = new TableViewerColumn(viewer, SWT.NONE);
    first.getColumn().setWidth(200);
    first.getColumn().setText("First");
    first.setLabelProvider(new ColumnLabelProvider()
    {
        @Override
        public void update(ViewerCell cell)
        {
            Object element = cell.getElement();
            if(element instanceof MyObject)
            {
                MyObject obj = (MyObject) element;
                cell.setText(obj.getFirst());
            }
        }
    });

    TableViewerColumn second = new TableViewerColumn(viewer, SWT.NONE);
    second.getColumn().setWidth(200);
    second.getColumn().setText("Second");
    second.setLabelProvider(new ColumnLabelProvider()
    {
        @Override
        public void update(ViewerCell cell)
        {
            Object element = cell.getElement();
            if(element instanceof MyObject)
            {
                MyObject obj = (MyObject) element;

                cell.setText(obj.getSecond());

                Integer colorCode = COLOR_MAPPING.get(obj.getSecond());

                if(colorCode != null)
                        cell.setForeground(Display.getDefault().getSystemColor(colorCode));
            }
        }
    });
}

private static class MyObject
{
    private String first;
    private String second;

    public MyObject(String first, String second)
    {
        this.first = first;
        this.second = second;
    }

    public String getFirst()
    {
        return first;
    }

    public void setFirst(String first)
    {
        this.first = first;
    }

    public String getSecond()
    {
        return second;
    }

    public void setSecond(String second)
    {
        this.second = second;
    }
}