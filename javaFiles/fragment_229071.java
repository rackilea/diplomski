@FXML
private ComboBox<ActionEventHandler> autoBox;

@FXML
private void initialize() {
    autoBox.getItems().setAll(
            new ActionEventHandler("action1", this::action1),
            new ActionEventHandler("action2", this::action2),
            new ActionEventHandler("action3", this::action3));
    autoBox.setOnAction(event -> {
        ActionEventHandler h = autoBox.getValue();
        if (h != null) {
            h.handle(event);
        }
    });
    autoBox.setConverter(new StringConverter<ActionEventHandler>() {

        @Override
        public String toString(ActionEventHandler object) {
            return object == null ? "" : object.toString();
        }

        @Override
        public ActionEventHandler fromString(String string) {
            if (string == null) {
                return null;
            }
            for (ActionEventHandler h : autoBox.getItems()) {
                if (string.equals(h.toString())) {
                    return h;
                }
            }
            return null;
        }

    });
    new AutoCompleteBox<>(autoBox);
}