TableColumn<DataClass, Boolean> statusCol = new TableColumn<>("Status");
statusCol.setCellValueFactory(new PropertyValueFactory<DataClass, Boolean>("priority"));
statusCol.setCellFactory(column -> {
    CheckBoxTableCell<DataClass, Boolean> cell = new CheckBoxTableCell<>();
    cell.setAlignment(Pos.CENTER);
    return cell;
});