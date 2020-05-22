class MyItem
{
    SimpleStringProperty nameProperty = new SimpleStringProperty("name");
    public MyItem(String name) {
        nameProperty.set(name);
    }
    public String getName() { return nameProperty.get(); }
    public void setName(String name) { nameProperty.set(name); }
    public SimpleStringProperty getNameProperty() { return nameProperty; }
}

...

TableView<MyItem> t = new TableView<MyItem>();
TableColumn col = new TableColumn("Name Header");
col.setCellValueFactory(new PropertyValueFactory<MyItem, String>("name"));
t.getColumns().addAll(t);

...

public void setValue(int row, int col, Object val)
{
    final MyItem selectedRow = t.getItems().get(row);
    final TableColumn<MyItem,?> selectedColumn = t.getColumns().get(col);
    // Lookup the propery name for this column
    final String propertyName =   ((PropertyValueFactory)selectedColumn.getCellValueFactory()).getProperty();
    try 
    {
        // Use reflection to get the property
        final Field f = MyItem.class.getField(propertyName);
        final Object o = f.get(selectedRow);

        // Modify the value based on the type of property
        if (o instanceof SimpleStringProperty)
        {
            ((SimpleStringProperty)o).setValue(val.toString());
        }
        else if (o instanceof SimpleIntegerProperty)
        {
            ...
        }
    } catch (Exception ex) {
        ex.printStackTrace();
    }
}