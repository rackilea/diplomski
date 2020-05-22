public static void main(String[] args)
{
    final Display display = new Display();
    Shell shell = new Shell(display);
    shell.setText("StackOverflow");
    shell.setLayout(new GridLayout(1, false));

    final Label centered = new Label(shell, SWT.NONE);
    centered.setText("Small text");
    centered.setLayoutData(new GridData(SWT.CENTER, SWT.FILL, true, true));

    Button changeText = new Button(shell, SWT.PUSH);
    changeText.setText("Change text");
    changeText.addListener(SWT.Selection, new Listener()
    {
        @Override
        public void handleEvent(Event arg0)
        {
            centered.setText("Loooooooooooooooooooong text");
            centered.getParent().layout();
        }
    });


    shell.pack();
    shell.setSize(600, 200);
    shell.open();
    while (!shell.isDisposed())
    {
        while (!display.readAndDispatch())
        {
            display.sleep();
        }
    }
}