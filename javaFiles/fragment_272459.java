myComboBox.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
    @Override
    public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
        //do something with selected index
    }
});