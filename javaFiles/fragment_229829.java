public static void main(String args[])
{
    Display display = new Display();
    final Shell shell = new Shell(display);
    shell.setText("StackOverflow");
    shell.setLayout(new GridLayout(1, false));

    Label bottom = new Label(shell, SWT.NONE);
    bottom.setText("Bottom");

    Label top = new Label(shell, SWT.NONE);
    top.setText("Top");

    shell.pack();
    shell.open();

    while (!shell.isDisposed())
    {
        if (!shell.getDisplay().readAndDispatch())
            shell.getDisplay().sleep();
    }
}