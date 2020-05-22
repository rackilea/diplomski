public static void main(String[] args)
{
    Display display = new Display();
    final Shell shell = new Shell(display);
    shell.setText("StackOverflow");
    shell.setLayout(new FillLayout());

    Menu menu = new Menu(shell, SWT.BAR);

    MenuItem item = new MenuItem(menu, SWT.CASCADE);
    item.setText("Menu");

    Menu submenu = new Menu(shell, SWT.DROP_DOWN);
    item.setMenu(submenu);

    for(int i = 0; i < 10; i++)
    {
        final MenuItem newItem = new MenuItem(submenu, SWT.NONE);
        newItem.setText("Item " + i);

        newItem.addListener(SWT.Selection, new Listener()
        {
            @Override
            public void handleEvent(Event arg0)
            {
                newItem.dispose();
            }
        });
    }

    shell.setMenuBar(menu);

    shell.pack();
    shell.setSize(400, 250);
    shell.open();
    while (!shell.isDisposed())
    {
        if (!display.readAndDispatch())
            display.sleep();
    }
    display.dispose();
}