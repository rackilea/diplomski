public static void main(String[] args)
{
    Display display = new Display();
    Shell shell = new Shell(display);

    RowLayout layout = new RowLayout();
    layout.center = true;

    shell.setLayout(layout);
    shell.setText("StackOverflow");

    new Label(shell, SWT.NONE).setText("Label");
    new Button(shell, SWT.PUSH).setText("Button");

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