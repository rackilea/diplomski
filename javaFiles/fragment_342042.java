BooleanBinding textField1Valid = Bindings.createBooleanBinding(() -> {
    // check textField1.getText() and return true/false as appropriate
}, textField1.textProperty());

BooleanBinding textField2Valid = Bindings.createBooleanBinding(() -> {
    // check textField2.getText() and return true/false as appropriate
}, textField2.textProperty());