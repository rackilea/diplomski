ObservableList<ActionEventHandler> data = FXCollections.observableArrayList(
        new ActionEventHandler("action1", this::action1),
        new ActionEventHandler("action2", this::action2),
        new ActionEventHandler("action3", this::action3)
);
FilteredList<ActionEventHandler> filtered = new FilteredList<>(data);
ComboBox<ActionEventHandler> comboBox = new ComboBox<>(filtered);
comboBox.setOnAction(event -> {
    ActionEventHandler h = comboBox.getValue();
    if (h != null) {
        h.handle(event);
    }
});
comboBox.setEditable(true);
comboBox.setConverter(new StringConverter<ActionEventHandler>() {

    @Override
    public String toString(ActionEventHandler object) {
        return object == null ? "" : object.toString();
    }

    @Override
    public ActionEventHandler fromString(String string) {
        if (string == null) {
            return null;
        }
        for (ActionEventHandler h : data) {
            if (string.equals(h.toString())) {
                return h;
            }
        }
        return null;
    }

});
comboBox.getEditor().textProperty().addListener((observable, oldValue, newValue) -> {
    filtered.setPredicate(h -> h.toString().startsWith(newValue));
});