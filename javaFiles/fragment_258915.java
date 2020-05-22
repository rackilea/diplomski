public static void main(String[] args)
{
    Display display = Display.getDefault();
    final Shell shell = new Shell(display);
    shell.setLayout(new GridLayout(1, true));

    final Composite resizable = new Composite(shell, SWT.BORDER);
    new Label(resizable, SWT.NONE).setText("Content");

    final GridData data = new GridData(SWT.FILL, SWT.BEGINNING, true, true);
    data.heightHint = 200;

    resizable.setLayoutData(data);

    Button button = new Button(shell, SWT.PUSH);
    button.setText("Resize");
    button.addListener(SWT.Selection, new Listener()
    {
        @Override
        public void handleEvent(Event arg0)
        {
            data.heightHint /= 2;
            shell.layout();
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