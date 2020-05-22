Slider slider1 = new Slider(0d, 0.25d, 0d);
Slider slider2 = new Slider(0d, 0.25d, 0d);
Slider slider3 = new Slider(0d, 0.25d, 0d);
Slider slider4 = new Slider(0d, 0.25d, 0d);

ProgressIndicator pi = new ProgressIndicator();

pi.progressProperty().bind(slider1.valueProperty().add(slider2.valueProperty())
        .add(slider3.valueProperty()).add(slider4.valueProperty()));