AbstractSelectionModel<T> selectionModel = (AbstractSelectionModel<T>)dataGrid.getSelectionModel();

ArrayList<Integer> intList = new ArrayList<Integer>();

List<Row> list = (List<Row>)_dataProvider.getList();

int i = 0;

for(Row row : list)
{
    if( selectionModel.isSelected(row) )
        intList.add(i);

    i++;
}