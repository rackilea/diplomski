public static void main(String[] args)
{

    Display display = new Display();
    Shell shell = new Shell(display);
    shell.setLayout(new FillLayout());

    Browser browser = new Browser(shell, SWT.NONE);
    browser.setText("<button id='button1' onclick='buttonClicked(this.id)'>Click me</button><button id='button2' onclick='buttonClicked(this.id)'>Click me</button>");

    new BrowserFunction(browser, "buttonClicked")
    {
        @Override
        public Object function(Object[] objects)
        {
            System.out.println("BUTTON CLICK; ID: " + objects[0]);
            return null;
        }
    };

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