ChangeListener<String> changeListener = new ChangeListener<>() {
    @Override
    public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
        ...
        nameFieldLoginStage.textProperty().removeListener(this);
    }
};
nameFieldLoginStage.textProperty().addListener(changeListener);