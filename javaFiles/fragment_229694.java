public static void main(String[] args)
{
    Display display = new Display();
    Shell shell = new Shell(display);
    shell.setText("StackOverflow");
    shell.setLayout(new FillLayout());

    final Text text = new Text(shell, SWT.BORDER);
    text.addListener(SWT.FocusOut, new Listener()
    {
        @Override
        public void handleEvent(Event event)
        {
            if (text.getText().trim().length() < 1)
            {
                Display.getDefault().asyncExec(new Runnable()
                {
                    @Override
                    public void run()
                    {
                        System.out.println("Please enter something!");
                        if (text != null && !text.isDisposed())
                        {
                            text.setFocus();
                            text.forceFocus();
                        }
                    }
                });
            }
            else
            {
                System.out.println("Nothing to see here, move along.");
            }
        }
    });

    new Text(shell, SWT.BORDER);

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