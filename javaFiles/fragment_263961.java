public static void main(String[] args)
{
    final Display display = new Display();
    final Shell shell = new Shell(display);
    shell.setLayout(new FillLayout());
    shell.setText("StackOverflow");

    Button button = new Button(shell, SWT.PUSH);
    button.setText("Open dialog");

    button.addListener(SWT.Selection, new Listener()
    {
        @Override
        public void handleEvent(Event arg0)
        {
            new MyDialog(shell, 5).open();
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

private static class MyDialog extends Dialog
{
    private int counter = 0;
    private int maxSeconds;

    public MyDialog(Shell parentShell, int maxSeconds)
    {
        super(parentShell);
        this.maxSeconds = maxSeconds;
        setShellStyle(SWT.APPLICATION_MODAL | SWT.CLOSE);
        setBlockOnOpen(true);
    }

    @Override
    protected Control createDialogArea(Composite parent)
    {
        Composite composite = (Composite) super.createDialogArea(parent);

        composite.setLayout(new GridLayout(1, false));

        final Display display = composite.getShell().getDisplay();
        final Label label = new Label(composite, SWT.NONE);
        label.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, true, true));

        /* Set up the timer here */
        final Runnable timer = new Runnable()
        {
            public void run()
            {
                if(!label.isDisposed())
                {
                    label.setText("" + counter++);
                    label.pack();
                    if(counter <= maxSeconds)
                        display.timerExec(1000, this);
                    else
                        MyDialog.this.close();
                }
            }
        };

        /* And start it */
        display.timerExec(0, timer);

        return composite;
    }

    @Override
    protected void configureShell(Shell newShell)
    {
        super.configureShell(newShell);
        newShell.setText("Dialog");
    }
}