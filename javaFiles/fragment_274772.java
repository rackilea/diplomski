acceptedCol.setCellValueFactory(new PropertyValueFactory<>("accepted"));

acceptedCol.setCellFactory((TableColumn<Person, Boolean> p) -> {
    CheckBoxTableCell<Person, Boolean> cell = new CheckBoxTableCell<>();
    cell.getStyleClass().add("custom-cell");
    cell.setAlignment(Pos.CENTER);
    return cell;
});