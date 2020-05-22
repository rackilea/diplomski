public static void main(String[] args)
{
    Display display = new Display();
    Shell shell = new Shell(display);
    shell.setLayout(new FillLayout());

    final Text text = new Text(shell, SWT.MULTI | SWT.BORDER | SWT.WRAP | SWT.V_SCROLL);

    Button button = new Button(shell, SWT.NONE);
    button.setText("Add text");
    button.addListener(SWT.Selection, new Listener()
    {
        @Override
        public void handleEvent(Event e)
        {

            text.append("y-intercept = \n");
            text.append("axis of symmetry = \n");
            text.append("1st zero = \n");
            text.append("2nd zero = \n");
        }
    });

    shell.pack();
    shell.setSize(400, 200);
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