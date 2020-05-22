int maxLength = 8;
final String matchString = "\\d{0," + maxLength + "}"; // allow 0 to maxLength digits

TextField textField = new TextField();
TextFormatter<?> formatter = new TextFormatter<>(change -> {
    String newText = change.getControlNewText();
    return newText.matches(matchString) ? change : null;
});
textField.setTextFormatter(formatter);