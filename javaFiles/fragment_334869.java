public void createPartControl(Composite parent) {
  parent.setLayout(new GridLayout(1, true));

  addSelectionButtons(parent); // Adds select/deselect all buttons

  myTableViewer = CheckboxTableViewer.newCheckList(parent, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);
  myTableViewer.getTable().setLayoutData(new GridData(GridData.FILL_BOTH));
  myTableViewer.setContentProvider(new MyContentProvider());
  myTableViewer.setLabelProvider(new MyLabelProvider());
  myTableViewer.setInput(getInput()); // Gets model

  TableColumn column = new TableColumn(myTableViewer.getTable(), SWT.FILL);
  column.setText("My column");
  column.pack();

  myTableViewer.getTable().setHeaderVisible(true);
  myTableViewer.getTable().setLinesVisible(true);
}