fields = new TextField[105];
for (int i = 0; i < fields.length; i++) {
    TextField textField = new TextField();
    fields[i] = textField ;
    textField.focusedProperty().addListener((obs, wasFocused, isNowFocused) -> {
        if (isNowFocused) {
            theFocusedTextField = textField ;
        } else {
            theFocusedTextField = null ;
        }
    });
}