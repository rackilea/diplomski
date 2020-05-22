// items empty initially
 TableView table = new TableView()
 table.itemsProperty().addListener(....)
 ObservableList empty = FXCollections.observableArrayList();
 // replace initial empty list by new empty list
 table.setItems(empty);
 // no change event was fired!