public void onModuleLoad() {
    final CellTable<Row> table = new CellTable<Row>();

    TextColumn<Row> firstColumn = new TextColumn<Starter.Row>() {

        @Override
        public String getValue(Row object) {
            return object.firstColumn;
        }
    };
    table.addColumn(firstColumn, "header one");

    TextColumn<Row> secondColumn = new TextColumn<Starter.Row>() {

        @Override
        public String getValue(Row object) {
            return object.secondColumn;
        }
    };
    table.addColumn(secondColumn, "header two");

    TextColumn<Row> thirdColumn = new TextColumn<Starter.Row>() {

        @Override
        public String getValue(Row object) {
            return object.thirdColumn;
        }
    };
    table.addColumn(thirdColumn, "header three");

    table.setRowCount(getList().size());
    final ListDataProvider<Row> dataProvider = new ListDataProvider<Starter.Row>(getList());
    dataProvider.addDataDisplay(table);

    final SingleSelectionModel<Row> selectionModel = new SingleSelectionModel<Starter.Row>();
    table.setSelectionModel(selectionModel);

    Button btn = new Button("delete entry");
    btn.addClickHandler(new ClickHandler() {

        @Override
        public void onClick(ClickEvent event) {
            Row selected = selectionModel.getSelectedObject();
            if (selected != null) {
                dataProvider.getList().remove(selected);
            }
        }
    });

    RootPanel.get().add(table);
    RootPanel.get().add(btn);

}

private class Row {

    private String firstColumn;
    private String secondColumn;
    private String thirdColumn;

    public Row(String firstColumn, String secondColumn, String thirdColumn) {
        this.firstColumn = firstColumn;
        this.secondColumn = secondColumn;
        this.thirdColumn = thirdColumn;
    }

}

private LinkedList<Row> getList() {
    LinkedList<Row> list = new LinkedList<Row>();
    list.add(new Row("first", "entry", "foo"));
    list.add(new Row("second", "entry", "foo"));
    list.add(new Row("third", "entry", "foo"));
    list.add(new Row("fourth", "entry", "foo"));
    return list;
}