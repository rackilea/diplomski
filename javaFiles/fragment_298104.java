Display                     display = new Display();
Shell                       shell   = new Shell(display);

private static final String lorem   = "Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet. Lorem ips";

public GridLayoutSample()
{
    shell.setLayout(new GridLayout(1, false));
    Composite row = new Composite(shell, SWT.NONE);
    row.setLayout(new GridLayout(1, false));
    row.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

    createButton(row, lorem, SWT.CHECK | SWT.WRAP);

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

public void createButton(final Composite parent, String text, int style)
{
    final GridData layoutData = new GridData(SWT.FILL, SWT.FILL, true, true);
    layoutData.widthHint = 175;
    final Button testButton = new Button(parent, style);
    testButton.setText(text);
    testButton.setLayoutData(layoutData);

    parent.getParent().addListener(SWT.Resize, new Listener()
    {
        @Override
        public void handleEvent(Event arg0)
        {
            layoutData.widthHint = parent.computeSize(SWT.DEFAULT, SWT.DEFAULT).x;
            parent.pack();
        }
    });
}

public static void main(String[] args)
{
    new GridLayoutSample();
}