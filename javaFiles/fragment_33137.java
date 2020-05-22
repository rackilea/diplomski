// Stored in variable so it can be removed if necessary
final ListChangeListener<String> listListener = listChange -> {
    // TODO: Implement...
};
names.addListener((MapChangeListener<String, ObservableList<String>>) mapChange -> {
    if (mapChange.wasAdded()) {
        mapChange.getValueAdded().addListener(listListener);
    } 
    if (mapChange.wasRemoved()) {
        mapChange.getValueRemoved().removeListener(listListener);
    }
});

// ListChangeListener will now be added automatically by the MapChangeListener
names.put("1", FXCollections.observableArrayList());