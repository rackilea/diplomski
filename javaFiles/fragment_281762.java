public static void main(String[] args)
{
    Display display = new Display();
    Shell shell = new Shell(display);
    shell.setLayout(new FillLayout());
    shell.setText("StackOverflow");

    Button open = new Button(shell, SWT.PUSH);
    open.setText("Open dialog");
    open.addListener(SWT.Selection, e -> new CountdownDialog(shell).open());

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

private static class CountdownDialog extends Dialog
{
    private static final int COUNTDOWN = 10;

    protected CountdownDialog(Shell parentShell)
    {
        super(parentShell);
    }

    @Override
    protected Control createDialogArea(Composite parent)
    {
        Composite container = (Composite) super.createDialogArea(parent);
        container.setLayout(new GridLayout());

        Label label = new Label(container, SWT.NONE);
        label.setText("Old Schedule has been found. Recover?");
        label.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false));

        Label countdown = new Label(container, SWT.NONE);
        countdown.setText(Integer.toString(COUNTDOWN));
        countdown.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false));

        new Thread(() -> {
            for (int i = COUNTDOWN - 1; i >= 0; i--)
            {
                try
                {
                    Thread.sleep(1000);
                }
                catch (final InterruptedException e)
                {
                    return;
                }

                if (parent.isDisposed())  // Stop thread when shell is closed
                    break;

                final boolean close = i == 0;
                final String newText = Integer.toString(i);
                Display.getDefault().asyncExec(() -> {
                    if(!countdown.isDisposed())
                        countdown.setText(newText);

                    if (close)
                        CountdownDialog.this.buttonPressed(IDialogConstants.CANCEL_ID);
                });
            }
        }).start();

        return container;
    }

    @Override
    protected void configureShell(Shell newShell)
    {
        super.configureShell(newShell);
        newShell.setText("Detected Recovery File");
    }

    @Override
    protected void createButtonsForButtonBar(Composite parent)
    {
        createButton(parent, IDialogConstants.OK_ID, "Yes", true);
        createButton(parent, IDialogConstants.CANCEL_ID, "No", false);
    }
}