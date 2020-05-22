public static void main(String args[])
{
    Display display = new Display();
    final Shell shell = new Shell(display);
    shell.setText("StackOverflow");
    shell.setLayout(new FillLayout());

    Button button = new Button(shell, SWT.PUSH);
    button.setText("Calculate");
    button.addListener(SWT.Selection, new Listener()
    {
        @Override
        public void handleEvent(Event arg0)
        {
            Rectangle outer = Display.getCurrent().getActiveShell().getBounds();
            Rectangle inner = Display.getCurrent().getActiveShell().getClientArea();

            System.out.println(outer.height - inner.height);
        }
    });

    shell.pack();
    shell.setSize(400, 200);
    shell.open();
    while (!shell.isDisposed())
    {
        if (!shell.getDisplay().readAndDispatch())
            shell.getDisplay().sleep();
    }
}