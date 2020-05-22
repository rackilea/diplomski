public static void main(String[] args)
{
    Display display = Display.getDefault();
    final Shell shell = new Shell(display);
    shell.setText("StackOverflow");
    shell.setLayout(new GridLayout(1, false));

    // This text is not scrollable
    final Text text = new Text(shell, SWT.MULTI | SWT.BORDER | SWT.WRAP | SWT.V_SCROLL);
    text.setLayoutData(new GridData(GridData.FILL_BOTH));

    text.setText("a\na\na\na\na\na\na\na\na\na\na\na\na\na\na\na\na\na\n");

    // This is the filter that prevents it
    display.addFilter(SWT.MouseWheel, new Listener()
    {
        @Override
        public void handleEvent(Event e)
        {
            // Check if it's the correct widget
            if(e.widget.equals(text))
                e.doit = false;
            else
                System.out.println(e.widget);
        }
    });

    // This text is scrollable
    final Text otherText = new Text(shell, SWT.MULTI | SWT.BORDER | SWT.WRAP | SWT.V_SCROLL);
    otherText.setLayoutData(new GridData(GridData.FILL_BOTH));

    otherText.setText("a\na\na\na\na\na\na\na\na\na\na\na\na\na\na\na\na\na\n");

    shell.pack();
    shell.open();
    while (!shell.isDisposed())
    {
        if (!display.readAndDispatch())
            display.sleep();
    }
    display.dispose();
}