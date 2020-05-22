public static void main(String args[])
{
    Display display = new Display();
    final Shell shell = new Shell(display);
    shell.setText("StackOverflow");
    shell.setLayout(new GridLayout(1, false));

    final StackLayout stackLayout = new StackLayout();

    final Composite stack = new Composite(shell, SWT.NONE);
    stack.setLayout(stackLayout);

    Label bottom = new Label(stack, SWT.NONE);
    bottom.setText("Bottom");

    Label top = new Label(stack, SWT.NONE);
    top.setText("Top");

    stackLayout.topControl = top;

    Button button = new Button(shell, SWT.PUSH);
    button.setText("Switch");
    button.addListener(SWT.Selection, new Listener()
    {
        @Override
        public void handleEvent(Event arg0)
        {
            stackLayout.topControl = stackLayout.topControl.equals(top) ? bottom : top;
            stack.layout(true, true);
        }
    });

    shell.pack();
    shell.open();

    while (!shell.isDisposed())
    {
        if (!shell.getDisplay().readAndDispatch())
            shell.getDisplay().sleep();
    }
}