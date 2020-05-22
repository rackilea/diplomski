public static void main(String[] args)
{
    final Display display = new Display();
    final Shell shell = new Shell(display);
    shell.setText("StackOverflow");
    shell.setLayout(new GridLayout());

    final TabFolder tabFolder = new TabFolder(shell, SWT.BORDER);

    for (int i= 0; i< 10; i++)
    {
        TabItem tabItem = new TabItem(tabFolder, SWT.NULL);
        tabItem.setText("Tab " + i);

        Text text = new Text(tabFolder, SWT.BORDER);
        text.setText("This is page " + i);
        tabItem.setControl(text);
    }

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