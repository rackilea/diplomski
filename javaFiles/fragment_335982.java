datePicker.valueProperty().addListener(new ChangeListener<LocalDate>() {
    @Override
    public void changed(ObservableValue<? extends LocalDate> observable, LocalDate oldValue, LocalDate newValue) {
        System.out.println("New Value: " + newValue);
    }
});
//Or using neat lambda
datePicker.valueProperty().addListener((observable, oldValue, newValue) -> {
    System.out.println("New Value: " + newValue);
});