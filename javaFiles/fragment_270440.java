public static void main(String[] args)
{
    final Display display = new Display();
    Shell shell = new Shell(display);
    shell.setLayout(new GridLayout(1, false));

    final Composite outer = new Composite(shell, SWT.NONE);
    outer.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
    GridLayout layout = new GridLayout(1, false);
    layout.marginHeight = 0;
    layout.marginWidth = 0;
    outer.setLayout(layout);

    Composite inner = new Composite(outer, SWT.NONE);
    inner.setBackground(display.getSystemColor(SWT.COLOR_WHITE));
    inner.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

    shell.addListener(SWT.Paint, new Listener()
    {
        public void handleEvent(Event e)
        {
            e.gc.setBackground(display.getSystemColor(SWT.COLOR_WIDGET_BORDER));
            Rectangle rect = outer.getBounds();
            Rectangle rect1 = new Rectangle(rect.x - 1, rect.y - 1, rect.width + 2, rect.height + 2);
            e.gc.setLineStyle(SWT.LINE_SOLID);
            e.gc.fillRectangle(rect1);
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