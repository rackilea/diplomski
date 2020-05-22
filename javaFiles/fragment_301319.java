public static void main(String[] args)
{
    Display display = new Display();
    final Shell shell = new Shell(display);
    shell.setLayout(new FillLayout(SWT.VERTICAL));
    shell.setText("StackOverflow");

    Monitor primary = display.getPrimaryMonitor();

        /* Get the available screen size (without start menu) */
    Rectangle area = primary.getClientArea();

    shell.pack();
    /* Set the shell size */
    shell.setBounds(area.x + area.width / 2, area.y, area.width / 2, area.height);
    shell.open();
    while (!shell.isDisposed())
    {
        if (!display.readAndDispatch())
            display.sleep();
    }
    display.dispose();
}