public static void main(String[] args)
{
    final Display d = new Display();
    Shell s = new Shell(d);

    d.addFilter(SWT.KeyDown, e ->
    {
        if (((e.stateMask & SWT.CTRL) == SWT.CTRL) && (e.keyCode == 'c'))
        {
            System.out.println("copy");
        }
        else if (((e.stateMask & SWT.CTRL) == SWT.CTRL) && (e.keyCode == 'v'))
        {
            System.out.println("paste");
        }
    });

    s.pack();
    s.open();

    while (!s.isDisposed())
    {
        if (!d.readAndDispatch())
            d.sleep();
    }
    d.dispose();
}