private static CheckBox createFruitCheckBox(final String text) {
    CheckBox result = new CheckBox(text);
    ChangeListener<Boolean> listener = (observable, oldValue, newValue) ->
                                               response.setText(newValue ? text + " Selected" : text + " cleared");

    result.selectedProperty().addListener(listener);
    return result;
}