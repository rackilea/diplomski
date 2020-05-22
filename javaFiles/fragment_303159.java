public static void main(String[] args)
{
    Display display = new Display();
    Shell shell = new Shell();
    shell.setText("StackOverflow");
    shell.setLayout(new FillLayout());

    StyledText text = new StyledText(shell, SWT.BORDER | SWT.MULTI);
    text.setFont(JFaceResources.getFont(JFaceResources.TEXT_FONT));
    text.setText("|i|m|\n|m|i|");

    shell.pack();
    shell.setSize(200, 100);
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