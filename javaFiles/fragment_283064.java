public static void main(String[] args)
{
    Display display = new Display();
    final Shell shell = new Shell(display);
    shell.setText("StackOverflow");
    shell.setLayout(new FillLayout());

    final Browser browser = new Browser(shell, SWT.NONE);
    browser.setText("......baz");

    Button b = new Button(shell, SWT.PUSH);
    b.setText("Do something");
    b.addListener(SWT.Selection, new Listener()
    {
        public void handleEvent(Event e)
        {
            String baz = "baz";
            boolean result = (boolean) browser.evaluate("return window.find('" + baz + "');");
            System.out.println(result);
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