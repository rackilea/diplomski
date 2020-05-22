int maxSeconds = ... ;
Slider slider = new Slider(0, maxSeconds, 0);
TextArea textArea = new TextArea();

Timeline timeline = new Timeline(
    new KeyFrame(Duration.ZERO, new KeyValue(slider.valueProperty(),0)),
    new KeyFrame(Duration.seconds(maxSeconds), new KeyValue(slider.valueProperty(),maxSeconds)));

textArea.textProperty().bind(Bindings.createStringBinding(
    () -> findInfoForTimepoint(slider.getValue()),
    slider.valueProperty()));