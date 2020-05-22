public void createPartControl(Composite parent) {
    GridData parentData = new GridData(SWT.FILL, SWT.FILL, true, true);
    parent.setLayout(new GridLayout(1, true));
    parent.setLayoutData(parentData);

    Composite searchMenu = new Composite(parent, SWT.BORDER);
    searchMenu.setLayout(new GridLayout(2, false));
    searchMenu.setLayoutData(new GridData(GridData.FILL, GridData.FILL, true, false));

    Text searchText = new Text(searchMenu, SWT.NONE);
    searchText.setLayoutData(new GridData(SWT.FILL, GridData.CENTER, true, false));
    searchText.setText("search text here");

    Button searchButton = new Button(searchMenu, SWT.PUSH);
    searchButton.setText("Search");

    Composite tableViewerComposite = new Composite(parent, SWT.BORDER);
    tableViewerComposite.setLayout(new GridLayout(1, true));
    tableViewerComposite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

    TableViewer tableViewer = new TableViewer(tableViewerComposite);
    TableViewerColumn column = new TableViewerColumn(tableViewer, SWT.NONE);
    column.getColumn().setWidth(200);
    column.setLabelProvider(new ColumnLabelProvider(){

        @Override
        public String getText(Object element) {
            return element != null ? element.toString() : "null";
        }});

    tableViewer.getControl().setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
    tableViewer.setContentProvider(ArrayContentProvider.getInstance());
    tableViewer.setInput(new String[]{"one", "two", "three"});

}