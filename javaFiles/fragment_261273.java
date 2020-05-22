ListView<String> listView = new ListView<>();
ComboBox<ObservableList<String>> comboBox = new ComboBox<>(...);
ChangeListener<ObservableList<String>> listener = (observable, oldList, newList) -> {
    if (newList == null) {
        newList = FXCollections.emptyObservableList();
    }
    listView.setItems(newList);
};
comboBox.valueProperty().addListener(listener);

// in case you assigned a initial value before
listener.changed(null, null, comboBox.getValue());