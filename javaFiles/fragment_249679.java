public static void main(String[] args)
{
    Display display = new Display();
    Shell shell = new Shell();
    shell.setLayout(new FillLayout());

    TabFolder folder = new TabFolder(shell, SWT.NONE);

    TabItem item = new TabItem(folder, SWT.NONE);
    item.setText("Item");

    Composite content = new Composite(folder, SWT.NONE);
    content.setLayout(new GridLayout(3, true));

    String[] myData = {"This", "is", "some", "random", "data"};

    for (String data : myData)
    {
        Button button = new Button(content, SWT.PUSH);
        button.setText(data);
        button.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
    }

    item.setControl(content);

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