ObservableSet<CheckBox> selectedCheckBoxes = FXCollections.observableSet();
CheckBox checkBox1 = new CheckBox();
checkBox1.selectedProperty().addListener((observable, oldValue, selectedNow) -> {
    if (selectedNow) {
        selectedCheckBoxes.add(checkBox1);
    } else {
        selectedCheckBoxes.remove(checkBox1);
    }
});