protected void createContents() {
    shell = new Shell();
    shell.setSize(450, 300);
    shell.setText("SWT Application");
    shell.setLayout(new GridLayout(1,false)); // change

    Menu menu = new Menu(shell, SWT.BAR);
    shell.setMenuBar(menu);

    MenuItem menuItem = new MenuItem(menu, SWT.CASCADE);
    menuItem.setText("New SubMenu");

    Menu menu_2 = new Menu(menuItem);
    menuItem.setMenu(menu_2);

    table = new Table(shell, SWT.BORDER | SWT.FULL_SELECTION );
    table.setHeaderVisible(true);
    table.setLinesVisible(true);
    table.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));  // change

    //ToolBar toolBar = new ToolBar(shell, SWT.FLAT | SWT.RIGHT);
    ToolBar toolBar = new ToolBar(shell, SWT.HORIZONTAL);

    ToolItem item = new ToolItem(toolBar, SWT.PUSH);
    item.setText("Button One");
}