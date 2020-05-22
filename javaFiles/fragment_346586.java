dialogPane.lookupButton(ButtonType.OK).disableProperty()
    .bind(Bindings.createBooleanBinding(
        () -> firstName.getText().trim().isEmpty() ||
              lastName.getText().trim().isEmpty() ||
              phoneNumber.getText().trim().isEmpty(),
        firstName.textProperty(),
        lastName.textProperty(),
        phoneNumber.textProperty()
    ));