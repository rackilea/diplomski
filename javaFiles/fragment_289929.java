// Table table;
// ScrolledComposite sc;
// int tableRowHeight;

protected void createTable() {

  ...

  // Set the listener that dictates the table row height.
  table.addListener(SWT.MeasureItem, new Listener() {
    @Override
    public void handleEvent(Event event) {
      event.height = tableRowHeight;
    }
  });

  // Set the listener for keeping the scrollbars in sync.
  table.getVerticalBar().addSelectionListener(new SelectionAdapter() {
    @Override
    public void widgetSelected(SelectionEvent e) {
      syncDeleteColumnScrollBar();
    }
  });
}

// This is extracted out into a method so it can also be called
// when removing a table row.
protected void syncDeleteColumnScrollBar() {
  sc.setOrigin(0, table.getVerticalBar().getSelection() * tableRowHeight);
}