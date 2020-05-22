UnaryOperator<TextFormatter.Change> filter = change -> change.getControlNewText().matches("[0-3]?\\p{XDigit}{0,3}") ? change : null;

StringConverter<Integer> converter = new StringConverter<Integer>() {

    @Override
    public String toString(Integer object) {
        return object == null ? "" : Integer.toHexString(object);
    }

    @Override
    public Integer fromString(String string) {
        return string == null || string.isEmpty() ? null : Integer.parseInt(string, 16);
    }

};

TextFormatter<Integer> formatter = new TextFormatter<>(converter, null, filter);
textField.setTextFormatter(formatter);