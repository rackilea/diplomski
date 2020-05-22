try {
    textField.validate();
} catch (Validator.InvalidValueException ex) {
    textField.setValidationVisible(true);
    Notification.show("Invalid value!");
}