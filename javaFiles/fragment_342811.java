private TableViewer viewer;
private List<WeeklyMenu> menu = Menu.MENU.getWeeklyMenu(); 

public void createPartControl(Composite parent) {
    Table table = createTable(parent);

    viewer.setInput(menu);

    for (TableItem item : table.getItems()) {
        WeeklyMenu weeklyMenu = (WeeklyMenu)item.getData();
        item.setChecked(weeklyMenu.isChecked());
    }

    viewer.refresh();

    table.addSelectionListener(new SelectionAdapter() {
        @Override
        public void widgetSelected(SelectionEvent e) {
            if( e.detail == SWT.CHECK ) 
            {
                TableItem item = (TableItem)e.item;
                WeeklyMenu weeklyMenu = (WeeklyMenu)item.getData();
                weeklyMenu.setChecked(item.getChecked());
            } 
        }
    });

}

private Table createTable(Composite parent) {
    viewer = new TableViewer(parent, SWT.BORDER | SWT.FULL_SELECTION | SWT.CHECK);
    Table table = viewer.getTable();
    table.setHeaderVisible(true);
    table.setLinesVisible(true);
    viewer.setContentProvider(new IStructuredContentProvider() {

        @Override
        public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
            // TODO Auto-generated method stub

        }

        @Override
        public void dispose() {
            // TODO Auto-generated method stub

        }

        @Override
        public Object[] getElements(Object inputElement) {
            return menu.toArray();
        }
    });

    createColumns(table);
    return table;
}

private void createColumns(Table table) {
    TableLayout layout = new TableLayout();
    layout.addColumnData(new ColumnWeightData(10, true));
    layout.addColumnData(new ColumnWeightData(20, true));
    layout.addColumnData(new ColumnWeightData(20, true));
    layout.addColumnData(new ColumnWeightData(20, true));
    layout.addColumnData(new ColumnWeightData(20, true));
    layout.addColumnData(new ColumnWeightData(20, true));
    layout.addColumnData(new ColumnWeightData(20, true));
    layout.addColumnData(new ColumnWeightData(20, true));
    layout.addColumnData(new ColumnWeightData(20, true));
    table.setLayout(layout);

    TableViewerColumn column = createTableViewerColumn("Checkbox");
    column.setLabelProvider(new ColumnLabelProvider(){
        @Override
        public String getText(Object element) {
            return "";
        }
    });

    column = createTableViewerColumn("Timing");
    column.setLabelProvider(new ColumnLabelProvider(){
        @Override
        public String getText(Object element) {
            return ((WeeklyMenu)element).getTiming();
        }
    });

    column = createTableViewerColumn("Monday");
    column.setLabelProvider(new ColumnLabelProvider(){
        @Override
        public String getText(Object element) {
            return ((WeeklyMenu)element).getMonFood();
        }
    });

    column = createTableViewerColumn("Tuesday");
    column.setLabelProvider(new ColumnLabelProvider(){
        @Override
        public String getText(Object element) {
            return ((WeeklyMenu)element).getTueFood();
        }
    });

    column = createTableViewerColumn("Wednesday");
    column.setLabelProvider(new ColumnLabelProvider(){
        @Override
        public String getText(Object element) {
            return ((WeeklyMenu)element).getWedFood();
        }
    });

    column = createTableViewerColumn("Thursday");
    column.setLabelProvider(new ColumnLabelProvider(){
        @Override
        public String getText(Object element) {
            return ((WeeklyMenu)element).getThuFood();
        }
    });

    column = createTableViewerColumn("Friday");
    column.setLabelProvider(new ColumnLabelProvider(){
        @Override
        public String getText(Object element) {
            return ((WeeklyMenu)element).getFriFood();
        }
    });

    column = createTableViewerColumn("Saturday");
    column.setLabelProvider(new ColumnLabelProvider(){
        @Override
        public String getText(Object element) {
            return ((WeeklyMenu)element).getSatFood();
        }
    });

    column = createTableViewerColumn("Sunday");
    column.setLabelProvider(new ColumnLabelProvider(){
        @Override
        public String getText(Object element) {
            return ((WeeklyMenu)element).getSunFood();
        }
    });
}

private TableViewerColumn createTableViewerColumn(String name) {
    TableViewerColumn viewerColumn = new TableViewerColumn(viewer, SWT.CENTER);
    TableColumn column = viewerColumn.getColumn();
    column.setText(name);
    column.setMoveable(true);
    return viewerColumn;
}