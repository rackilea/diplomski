public static void main(String[] args)
{
    final Display display = new Display();
    Shell shell = new Shell(display);
    shell.setLayout(new GridLayout(1, false));

    Button button = new Button(shell, SWT.PUSH);
    button.setText("Button");

    final Shell popup = new Shell(shell, SWT.NONE);
    popup.setLayout(new FillLayout());

    Text input = new Text(popup, SWT.BORDER);

    button.addListener(SWT.Selection, new Listener()
    {
        @Override
        public void handleEvent(Event event)
        {
            if(popup != null && !popup.isDisposed())
                popup.close();
        }
    });

    shell.pack();
    shell.open();

    popup.pack();
    popup.open();

    popup.setLocation(button.toDisplay(button.getBounds().width, 1));

    while (!shell.isDisposed())
    {
        if (!display.readAndDispatch())
        {
            display.sleep();
        }
    }
    display.dispose();
}