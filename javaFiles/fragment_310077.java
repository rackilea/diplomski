public static void main(String[] args)
{
    final Display display = new Display();
    final Shell shell = new Shell(display);
    shell.setText("StackOverflow");
    shell.setLayout(new GridLayout(4, false));

    Text text = new Text(shell, SWT.BORDER);
    text.setLayoutData(new GridData(SWT.BEGINNING, SWT.TOP, false, true, 4, 1));

    text = new Text(shell, SWT.BORDER);
    text.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, true, 4, 1));

    for (int i = 0; i < 8; i++)
    {
        new Button(shell, SWT.PUSH).setText("Button " + i);
    }

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