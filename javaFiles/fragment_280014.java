label.textProperty().bind(
    Bindings.createStringBinding(
        () -> String.format("%.2f", firstSlider.getValue()*secondSlider.getValue()), 
        firstSlider.valueProperty(), secondSlider.valueProperty()
    )
);