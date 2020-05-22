firstSliderValue.textProperty().bind(
    Bindings.createStringBinding(
        () -> getDisplayMemory((int) Math.round(firstSlider.getValue())),
        firstSlider.valueProperty()
    )
);
secondSliderValue.textProperty().bind(
    Bindings.createStringBinding(
        () -> getDisplayFrequency((int) Math.round(secondSlider.getValue())),
        secondSlider.valueProperty()
    )
);