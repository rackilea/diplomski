Slider hRuler = new Slider(0, 160, 10);
hRuler.showTickMarksProperty().setValue(true);
hRuler.showTickLabelsProperty().setValue(true);
hRuler.getStyleClass().add("axis-top");

Slider vRuler = new Slider(0, 100, 10);
vRuler.setOrientation(Orientation.VERTICAL);
vRuler.showTickMarksProperty().setValue(true);
vRuler.showTickLabelsProperty().setValue(true);
vRuler.getStyleClass().add("axis-left");