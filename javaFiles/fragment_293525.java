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

    final Composite[] pages = new Composite[5];

    for (int i = 0; i < pages.length; i++)
    {
        pages[i] = new Composite(parent, SWT.NONE);
        pages[i].setLayout(new GridLayout(3, true));
        pages[i].setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

        for (int j = 0; j < 9; j++)
            new Label(pages[i], SWT.NONE).setText("C" + i + " B" + j);

        Button goToNext = new Button(pages[i], SWT.PUSH);
        goToNext.setText("Go to next");
        goToNext.addListener(SWT.Selection, new Listener()
        {
            @Override
            public void handleEvent(Event arg0)
            {
                current = (current + 1) % pages.length;
                layout.topControl = pages[current];
                parent.layout();
            }
        });
    }

    layout.topControl = pages[0];

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