public static void main(String[] args)
{
    final Display display = new Display();
    final Shell shell = new Shell(display);
    shell.setText("StackOverflow");
    shell.setLayout(new GridLayout());

    Text text = new Text(shell, SWT.BORDER);

    text.addListener(SWT.MouseUp, new Listener()
    {
        @Override
        public void handleEvent(Event e)
        {
            if ((e.stateMask & SWT.SHIFT) != 0 && e.button == 1)
            {
                System.out.println("shift pressed and left mouse clicked");
            }
        }
    });

    shell.pack();
    shell.open();

    shell.layout(true, true);

    while (!shell.isDisposed())
    {
        if (!display.readAndDispatch())
            display.sleep();
    }
    display.dispose();
}