public static void main(String args[])
{
    Display display = new Display();
    final Shell shell = new Shell(display);
    shell.setText("StackOverflow");
    shell.setLayout(new FillLayout());

    Spinner spinner = new Spinner(shell, SWT.READ_ONLY);
    spinner.addListener(SWT.Verify, new Listener()
    {
        @Override
        public void handleEvent(Event e)
        {
            if(e.keyCode == SWT.ARROW_UP || e.keyCode == SWT.ARROW_DOWN)
            {
                e.doit = false;
            }
        }
    });

    shell.pack();
    shell.setSize(100, shell.computeSize(SWT.DEFAULT, SWT.DEFAULT).y);
    shell.open();

    while (!shell.isDisposed())
    {
        if (!shell.getDisplay().readAndDispatch())
            shell.getDisplay().sleep();
    }
}