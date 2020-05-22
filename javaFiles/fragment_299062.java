public static void main(String[] args)
{
    final Display display = new Display();

    Shell shell = new Shell(display);
    shell.setText("StackOverflow");
    shell.setLayout(new GridLayout(2, false));

    Composite chessBoard = new Composite(shell, SWT.BORDER);
    chessBoard.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

    Composite settings = new Composite(shell, SWT.BORDER);
    GridData data = new GridData(SWT.END, SWT.FILL, false, true);
    data.widthHint = 100;
    settings.setLayoutData(data);

    shell.pack();
    shell.open();
    shell.setSize(400, 200);
    while (!shell.isDisposed())
    {
        if (!display.readAndDispatch())
            display.sleep();
    }
}