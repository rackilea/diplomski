textField.setTextChangeEventMode(TextChangeEventMode.LAZY);
textField.setNullRepresentation("");

textField.addTextChangeListener(new FieldEvents.TextChangeListener() {
    @Override
    public void textChange(FieldEvents.TextChangeEvent event) {
        try {
            textField.setValue(event.getText());

            // workaround cursor position problem
            textField.setCursorPosition(event.getCursorPosition());

            textField.validate();
            } catch (InvalidValueException e) {
                log.warn("validation error: " + e.getMessage() + " and value was: {}", delegate.getValue());
            }
    }
});