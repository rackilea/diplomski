public static void main(String[] args)
{
    Display display = new Display();
    Shell shell = new Shell(display);
    new ExpandBarExample(shell);
    shell.setMaximized(true);
    shell.setLayout(new FillLayout());
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

private ExpandBar           bar;
private ScrolledComposite   scroll;
private Composite           composite;
private SashForm            sash;
private CTabFolder          folder;
private Button              button;

public ExpandBarExample(Composite composite)
{
    this.composite = composite;

    init();
}

public void init()
{

    composite.setLayout(new FillLayout());
    sash = new SashForm(composite, SWT.VERTICAL);

    folder = new CTabFolder(sash, SWT.None);

    scroll = new ScrolledComposite(folder, SWT.V_SCROLL);
    GridData data = new GridData();
    data.grabExcessHorizontalSpace = true;
    data.grabExcessVerticalSpace = true;

    bar = new ExpandBar(scroll, SWT.NONE);
    scroll.setContent(bar);
    scroll.setExpandVertical(true);
    scroll.setExpandHorizontal(true);
    scroll.setAlwaysShowScrollBars(true);

    CTabItem tab = new CTabItem(folder, SWT.None);
    tab.setControl(scroll);
    tab.setText("TEST");

    Composite sashFill = new Composite(sash, SWT.BORDER);
    sashFill.setLayout(new FillLayout());
    button = new Button(sashFill, SWT.PUSH);
    button.addListener(SWT.Selection, new Listener()
    {
        @Override
        public void handleEvent(Event arg0)
        {
            Composite comp = new Composite(bar, SWT.BORDER);
            comp.setLayout(new GridLayout(2, false));
            for (int a = 0; a < 10; a++)
            {
                Label label = new Label(comp, SWT.BORDER);
                label.setText("TEST");
            }
            comp.layout(true);
            addItem(comp, "ADDED");

            scroll.setMinSize(bar.computeSize(SWT.DEFAULT, SWT.DEFAULT, true));
            scroll.layout(true, true);
        }
    });
    button.setText("Add block");

    sash.setWeights(new int[] { 3, 1 });

    scroll.setMinSize(bar.computeSize(SWT.DEFAULT, SWT.DEFAULT));
    scroll.layout(true);
}

public void refresh()
{

}

public void removeAll()
{
    ExpandItem[] items = bar.getItems();
    System.out.println(items.length);

    for (int a = items.length - 1; a >= 0; a--)
    {
        items[a].getControl().dispose();
        items[a].dispose();
    }
}

public void addItem(Composite composite, String tabName)
{
    final ExpandItem expandItem = new ExpandItem(bar, SWT.None);
    expandItem.setText(tabName);
    expandItem.setControl(composite);
    expandItem.setExpanded(true);
    expandItem.setHeight(composite.computeSize(SWT.DEFAULT, SWT.DEFAULT).y);

    Display.getDefault().timerExec(300, new Runnable()
    {
        @Override
        public void run()
        {
            scroll.setMinSize(bar.computeSize(SWT.DEFAULT, SWT.DEFAULT, true));
            scroll.layout(true, true);
        }
    });
}