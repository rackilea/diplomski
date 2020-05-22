private EventHandler<KeyEvent> textFieldKeyEventHandler = event -> {
    if (textField == null || ! getSkinnable().isEditable()) return;
    handleKeyEvent(event, true);
};

...

private void handleKeyEvent(KeyEvent ke, boolean doConsume) {
    // When the user hits the enter or F4 keys, we respond before
    // ever giving the event to the TextField.
    if (ke.getCode() == KeyCode.ENTER) {
        setTextFromTextFieldIntoComboBoxValue();

        if (doConsume) ke.consume();
    } 
    ...
}