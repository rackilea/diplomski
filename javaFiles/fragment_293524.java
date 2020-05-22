private static int current = 0;

public static void main(String[] args)
{
    final Display display = new Display();
    final Shell shell = new Shell(display);
    shell.setText("StackOverflow");
    shell.setLayout(new GridLayout());

    final Composite parent = new Composite(shell, SWT.NONE);
    parent.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
    final StackLayout layout = new StackLayout();
    parent.setLayout(layout);

    final Button[] buttons = new Button[10];
    for (int i = 0; i < 10; i++)
    {
        buttons[i] = new Button(parent, SWT.PUSH);
        buttons[i].setText("Button " + i);
    }
    layout.topControl = buttons[0];

    Button switchButton = new Button(shell, SWT.PUSH);
    switchButton.setText("Show Next Button");
    switchButton.addListener(SWT.Selection, new Listener()
    {
        public void handleEvent(Event e)
        {
            current = (current + 1) % buttons.length;
            layout.topControl = buttons[current];
            parent.layout();
        }
    });

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