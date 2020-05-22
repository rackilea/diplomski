rating.ratingProperty().addListener(new ChangeListener<Number>() {
    @Override
    public void changed(ObservableValue<? extends Number> observable,
                Number oldValue, Number newValue) {
        textField.setText(newValue.toString()); 
    }
});