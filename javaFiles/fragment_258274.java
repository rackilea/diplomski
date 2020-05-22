public static String fileSizeToText(long fileSize) {
     return round(((float) fileSize) / 1024 / 1024, 2) + "mb";
}

...

TableColumn<MyClass, Number> fileSizeColumn = ...
fileSizeColumn.setCellValueFactory(cellData -> cellData.getValue().fileSizeProperty());
fileSizeColumn.setCellFactory(c -> new TableCell<MyClass, Number>() {

    @Override
    protected void updateItem(Number item, boolean empty) {
        super.updateItem(item, empty);
        if (empty || item == null) {
             setText(null);
        } else {
             setText(fileSizeToText(item.longValue()));
        }
    }

});