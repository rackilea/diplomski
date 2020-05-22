public static void main(String[] args)
{
    Display display = new Display();
    final Shell shell = new Shell(display);
    shell.addListener(SWT.Close, new Listener()
    {
        public void handleEvent(Event event)
        {
            int style = SWT.APPLICATION_MODAL | SWT.YES | SWT.NO;
            MessageBox messageBox = new MessageBox(shell, style);
            messageBox.setText("Information");
            messageBox.setMessage("Close the shell?");
            event.doit = messageBox.open() == SWT.YES;
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