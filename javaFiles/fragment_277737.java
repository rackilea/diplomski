private static Map<ExpandItem, StyledText> mapping = new HashMap<>();

public static void main(String[] args)
{
    Display display = new Display();
    Shell shell = new Shell(display);
    shell.setText("StackOverflow");
    shell.setLayout(new FillLayout());

    final ExpandBar bar = new ExpandBar(shell, SWT.V_SCROLL);

    for (int i = 0; i < 3; i++)
        addExpandItem(bar, i);

    bar.addExpandListener(new ExpandListener()
    {
        @Override
        public void itemExpanded(ExpandEvent e)
        {
            ExpandItem item = (ExpandItem) e.item;

            expandItem(mapping.get(item));
        }

        @Override
        public void itemCollapsed(ExpandEvent e)
        {

        }
    });

    Button button = new Button(shell, SWT.PUSH);
    button.setText("Expand first");
    button.addListener(SWT.Selection, new Listener()
    {
        @Override
        public void handleEvent(Event event)
        {
            expandItem(bar.getItem(0));
        }
    });

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

private static void expandItem(ExpandItem item)
{
    ExpandBar bar = item.getParent();

    item.setExpanded(true);
    Event e = new Event();
    e.item = item;
    bar.notifyListeners(SWT.Expand, e);
}

private static void expandItem(final StyledText text)
{
    if (text != null && !text.isDisposed())
    {
        Display.getDefault().asyncExec(new Runnable()
        {
            @Override
            public void run()
            {
                if (text != null && !text.isDisposed())
                {
                    text.setFocus();
                    text.forceFocus();
                }
            }
        });
    }
}

private static void addExpandItem(ExpandBar bar, int i)
{
    ExpandItem item = new ExpandItem(bar, SWT.NONE);
    item.setText("Item " + i);

    Composite content = new Composite(bar, SWT.NONE);
    content.setLayout(new FillLayout());

    final StyledText text = new StyledText(content, SWT.BORDER);
    item.setControl(content);
    item.setHeight(content.computeSize(SWT.DEFAULT, SWT.DEFAULT).y);

    mapping.put(item, text);
}