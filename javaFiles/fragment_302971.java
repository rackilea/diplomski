private static Shell popup;

public static void main(String[] args)
{
    Display d = new Display();
    final Shell shell = new Shell(d);
    shell.setLayout(new FillLayout());
    final Button button = new Button(shell, SWT.PUSH);
    button.setText("test");

    button.addListener(SWT.MouseEnter, new Listener()
    {
        public void handleEvent(Event e)
        {
            callPopUp(e, shell);
        }
    });
    button.addListener(SWT.MouseExit, new Listener()
    {
        public void handleEvent(Event e)
        {
            hidePopUp();
        }
    });

    shell.pack();
    shell.open();

    while (!shell.isDisposed())
    {
        if (!d.readAndDispatch())
        {
            d.sleep();
        }
    }
    d.dispose();
}

private static void hidePopUp()
{
    if (popup != null && !popup.isDisposed())
    {
        popup.close();
        popup = null;
    }
}

private static void callPopUp(Event e, Shell shell)
{
    System.out.println("CREATE");
    if (popup == null)
    {
        popup = new Shell(shell.getDisplay(), SWT.NO_TRIM | SWT.ON_TOP | SWT.MODELESS);
        popup.setLayout(new FillLayout());
        new Label(popup, SWT.NONE).setText("Howdy");
        popup.pack();
        popup.open();
        shell.forceFocus();
    }

    popup.setLocation(shell.getLocation().x + e.x, shell.getLocation().y + e.y);
}