public static void main(String[] args) {
    Display display = new Display();
    final Shell shell = new Shell(display);
    final TabFolder tabFolder = new TabFolder(shell, SWT.BORDER);
    for (int i = 0; i < 6; i++) {
      TabItem item = new TabItem(tabFolder, SWT.NONE);
      item.setText("TabItem " + i);
      item.setToolTipText("This is my tab" + i);

      Composite composite = new Composite(tabFolder, SWT.NONE);
      composite.setLayout(new FillLayout());
      new Button(composite, SWT.PUSH).setText("Button");
      new Text(composite, SWT.BORDER).setText("TextField");
      new Label(composite, SWT.NONE).setText("Label");

      Table table = new Table(composite, SWT.NONE);
      table.setHeaderVisible(true);

      new TableItem(table, SWT.NONE).setText("TableItem");

      item.setControl(composite);

    }
    tabFolder.pack();
    shell.pack();
    shell.open();
    while (!shell.isDisposed()) {
      if (!display.readAndDispatch())
        display.sleep();
    }
}