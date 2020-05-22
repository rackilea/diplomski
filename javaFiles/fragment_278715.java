try {
    textField.validate();
} catch (Validator.InvalidValueException ex) {
    for (Validator.InvalidValueException cause: ex.getCauses()) {
        System.err.println(cause.getMessage());
    }
}