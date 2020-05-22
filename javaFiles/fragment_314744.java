textField.textProperty().bind(new StringBinding() {
    {
        bind(someDoubleProperty);
    }

    @Override
    protected String computeValue() {
        return Double.toString(someDoubleProperty.get());
    }
});