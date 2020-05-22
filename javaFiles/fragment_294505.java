public static void main(String[] args)
{
    final Display display = new Display();
    final Shell shell = new Shell(display);
    shell.setText("StackOverflow");
    shell.setLayout(new GridLayout());
    shell.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

    final Composite comp = new Composite(shell, SWT.BORDER);

    final GridLayout layout = new GridLayout(2, false);
    layout.horizontalSpacing = 50;

    comp.setLayout(layout);
    comp.setLayoutData(new GridData(SWT.CENTER, SWT.TOP, true, false));

    Button first = new Button(comp, SWT.PUSH);
    first.setText("First");
    first.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false));

    Button second = new Button(comp, SWT.PUSH);
    second.setText("Second");
    second.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false));

    shell.addListener(SWT.Resize, new Listener()
    {
        @Override
        public void handleEvent(Event event)
        {
            int width = shell.getSize().x;
            layout.horizontalSpacing = (int) Math.round(0.1 * width);
            shell.layout(true, true);
        }
    });

    shell.pack();
    shell.open();

    shell.forceFocus();

    while (!shell.isDisposed())
    {
        if (!display.readAndDispatch())
            display.sleep();
    }
    display.dispose();
}