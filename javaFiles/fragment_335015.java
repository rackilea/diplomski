public static void main(String[] args)
{
    Display display = new Display();
    final Shell shell = new Shell(display);
    shell.setLayout(new GridLayout(1, false));

    final Composite content = new Composite(shell, SWT.NONE);
    content.setLayout(new GridLayout(2, false));

    Text text = new Text(content, SWT.BORDER);
    Button button = new Button(content, SWT.PUSH);
    button.setText("Button");

    display.addFilter(SWT.KeyUp, new Listener()
    {
        @Override
        public void handleEvent(Event e)
        {
            if (e.widget instanceof Control && isChild(content, (Control) e.widget))
            {
                if ((e.stateMask & SWT.CTRL) == SWT.CTRL)
                {
                    System.out.println("Ctrl pressed");
                }
                else if(e.keyCode == SWT.ESC)
                {
                    System.out.println("Esc pressed");
                }
            }
        }
    });

    Text outsideText = new Text(shell, SWT.BORDER);

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

private static boolean isChild(Control parent, Control child)
{
    if (child.equals(parent))
        return true;

    Composite p = child.getParent();

    if (p != null)
        return isChild(parent, p);
    else
        return false;
}