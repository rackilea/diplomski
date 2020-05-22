public static void main(String[] args)
{
    final Display display = Display.getDefault();
    final Shell shell = new Shell(display);
    shell.setLayout(new GridLayout(1, false));

    final Composite outer = new Composite(shell, SWT.NONE);
    outer.setBackground(display.getSystemColor(SWT.COLOR_BLUE));
    GridLayout layout = new GridLayout(1, false);
    layout.marginHeight = 0;
    outer.setLayout(layout);
    outer.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

    final Composite inner = new Composite(outer, SWT.NONE);
    inner.setBackground(display.getSystemColor(SWT.COLOR_RED));
    inner.setLayout(new GridLayout(1, false));
    inner.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

    shell.pack();
    shell.open();

    while (!shell.isDisposed())
    {
        if (!display.readAndDispatch())
            display.sleep();
    }
    display.dispose();
}