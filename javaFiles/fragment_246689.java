button.disableProperty().bind(new BooleanBinding() {
    { bind(textField.textProperty()); }
    @Override
    public boolean computeValue() {
        return textField.getText().isEmpty() ;
    }
});