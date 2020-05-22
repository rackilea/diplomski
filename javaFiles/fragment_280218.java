ListView<String> listView = new ListView<>();
    ObservableList<String> list = FXCollections.observableArrayList();
    listView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
    listView.setItems(list);
    list.add("Item 1");
    list.add("Item 2");
    list.add("Item 3");

    List<String> selected = listView.getSelectionModel().getSelectedItems();