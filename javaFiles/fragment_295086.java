Slider slider1 = new Slider(0d, 1d, 0d);
Slider slider2 = new Slider(0d, 1d, 0d);
Slider slider3 = new Slider(0d, 1d, 0d);
Slider slider4 = new Slider(0d, 1d, 0d);

ProgressIndicator pi = new ProgressIndicator();

pi.progressProperty().bind(slider1.valueProperty().divide(4d).add(slider2.valueProperty().divide(4d))
        .add(slider3.valueProperty().divide(4d)).add(slider4.valueProperty().divide(4d)));

VBox vbox = new VBox();
vbox.getChildren().addAll(slider1, slider2, slider3, slider4, pi);