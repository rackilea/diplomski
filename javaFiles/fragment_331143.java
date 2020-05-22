textField.focusedProperty().addListener(
        (ObservableValue<? extends Boolean> arg0,
         Boolean arg1, Boolean arg2) -> {
            if (!arg2) {
                commitEdit(textField.getText());
            }
        });