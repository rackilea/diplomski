ComboBox<Integer> comboBox = new ComboBox<>(FXCollections.observableArrayList(1, 3, 5, 7));
ObservableList<Integer> numList = FXCollections.observableArrayList();
ListView<Integer> listView = new ListView<>(numList);

ChangeListener<Integer> listener = (observable, oldCount, newCount) -> {
    int size = numList.size();
    int newSize = newCount == null ? 0 : newCount;
    if (size > newSize) {
        numList.subList(newSize, size).clear();
    } else {
        for (int i = size+1; i <= newSize; i++) {
            numList.add(i);
        }
    }
};

comboBox.valueProperty().addListener(listener);

// in case you assigned a initial value before
listener.changed(null, null, comboBox.getValue());