// variables 
@UiField
DataGrid<DataRow<Cell>> formDataTable;

public static final ProvidesKey<DataRow<Cell>> KEY_PROVIDER = new ProvidesKey<DataRow<Cell>>() {
    @Override
    public Object getKey(DataRow<Cell> item) {
        return item.getIndex();
    }
};

private SingleSelectionModel<DataRow<Cell>> selectionModel;


// this code must be within constructor
selectionModel = new SingleSelectionModel<DataRow<Cell>>(KEY_PROVIDER);
formDataTable.setSelectionModel(selectionModel);

// method to select should view as
@Override
public void setFocus(final Long rowIndex) {
    DataRow<Cell> row = new DataRow<Cell>();
    row.setIndex(rowIndex.intValue());
    selectionModel.setSelected(row, true);

    // go to essential page
    Long page = rowIndex / pager.getPageSize() + (rowIndex % pager.getPageSize() > 0 ? 1:0);
    pager.setPage(page.intValue() - 1);
}