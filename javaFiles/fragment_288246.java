public static void main(String[] args)
{
    Display display = new Display();
    Shell shell = new Shell();
    shell.setText("StackOverflow");
    shell.setLayout(new GridLayout(1, false));

    MyGroup first = new MyGroup(shell, SWT.BORDER);
    first.setHeader("A");
    first.addStrings("A1 A1 A1 A1 A1 A1 A1 A1", "A2 A2 A2 A2 A2 A2", "A3 A3 A3 A3");

    MyGroup second = new MyGroup(shell, SWT.BORDER);
    second.setHeader("B");
    second.addStrings("B1", "B2");

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

private static class MyGroup extends Composite
{
    private Button      button;
    private Composite   content;

    public MyGroup(Composite parent, int style)
    {
        super(parent, style);

        setLayout(new GridLayout(1, false));
        setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

        button = new Button(this, SWT.CHECK);
        content = new Composite(this, SWT.NONE);

        GridLayout layout = new GridLayout(1, false);
        layout.marginLeft = 20;

        content.setLayout(layout);
        content.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
    }

    public void setHeader(String header)
    {
        button.setText(header);
    }

    public void addStrings(String... strings)
    {
        for (String string : strings)
            new Label(content, SWT.NONE).setText(string);
    }
}