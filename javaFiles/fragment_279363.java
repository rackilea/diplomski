table.setRowFactory(param ->
{
    TableRow<Integer> row = new TableRow<>();

    row.disableProperty().bind(disable);

    return row;
});