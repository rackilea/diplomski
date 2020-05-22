TableColumn<FileModel, Void> indexCol = new TableColumn<>("Index");
indexCol.setCellFactory(col -> {
    TableCell<FileModel, Void> cell = new TableCell<>();
    cell.textProperty().bind(Bindings.createStringBinding(() -> {
        if (cell.isEmpty()) {
            return null ;
        } else {
            return Integer.toString(cell.getIndex());
        }
    }, cell.emptyProperty(), cell.indexProperty()));
    return cell ;
});