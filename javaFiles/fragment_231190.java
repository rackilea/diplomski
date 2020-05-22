final CellTable<TableType> table = new CellTable<TableType>();

AbstractCell<TableType> buttonCell = new AbstractCell<ButtonCellTest.TableType>(ClickEvent.getType().getName()) {
    @Override
    public void render(Context context, TableType value, SafeHtmlBuilder sb) {
        Button button = new Button();
        button.setType(ButtonType.SUCCESS);
        button.setSize(ButtonSize.SMALL);
        button.add(new Icon(value.isClicked() ? IconType.CHECK : IconType.TIMES));
        sb.append(SafeHtmlUtils.fromTrustedString(button.toString()));
    }

    @Override
    public void onBrowserEvent(Context context, Element parent, TableType value, NativeEvent event, ValueUpdater<TableType> valueUpdater) {
        value.setClicked(!value.isClicked());
        // ... do stuff...
        table.redrawRow(context.getIndex());
    }
};
table.addColumn(new Column<TableType, TableType>(buttonCell) {
    @Override
    public TableType getValue(TableType object) {
        return object;
    }
});

ArrayList<TableType> rowData = new ArrayList<TableType>();
rowData.add(new TableType("row 1"));
rowData.add(new TableType("row 2"));
...
table.setRowData(rowData);