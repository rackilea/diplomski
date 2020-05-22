public static void main(String[] args)
{
    Display display = Display.getDefault();
    final Shell shell = new Shell(display);
    shell.setLayout(new GridLayout(1, false));

    final Text text = new Text(shell, SWT.BORDER | SWT.MULTI);
    text.setText("edasdasdas\n\nasdasda\n\nasdasd");

    final GridData data = new GridData(SWT.FILL, SWT.BEGINNING, true, false);
    data.heightHint = 100;

    text.setLayoutData(data);

    text.addListener(SWT.FocusIn, new Listener()
    {
        @Override
        public void handleEvent(Event arg0)
        {
            data.heightHint = 100;
            shell.layout(true);
        }
    });

    text.addListener(SWT.FocusOut, new Listener()
    {
        @Override
        public void handleEvent(Event arg0)
        {
            data.heightHint = 50;
            shell.layout(true);
        }
    });

    Button button = new Button(shell, SWT.PUSH);
    button.setText("Button");

    shell.pack();
    shell.open();
    while (!shell.isDisposed())
    {
        if (!display.readAndDispatch())
            display.sleep();
    }
    display.dispose();
}