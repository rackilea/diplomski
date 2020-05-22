label.textProperty().bind(
        Bindings.createStringBinding(
                () -> new StringBuilder(textField.getText()).reverse().toString(),
                textField.textProperty()
        )
);