public static void main(String[] args)
{
    Display display = new Display();
    final Shell shell = new Shell(display);
    shell.setText("StackOverflow");
    shell.setLayout(new GridLayout(1, false));

    final Button left = new Button(shell, SWT.PUSH);
    left.setText("Restricted width");
    left.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

    left.addListener(SWT.Resize, new Listener()
    {
        @Override
        public void handleEvent(Event arg0)
        {
            Point size = left.getSize();

            if(size.x > 200)
            {
                left.setSize(200, size.y);
            }
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