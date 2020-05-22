@Override
public void start(Stage stage) throws Exception {
    Slider s = new Slider();
    s.setLabelFormatter(new StringConverter<Double>() {
        @Override
        public String toString(Double t) {
            return String.valueOf(Math.round(Math.pow(2, t)));
        }

        @Override
        public Double fromString(String string) {
            return Double.parseDouble(string);
        }
    });

    s.setMin(0);
    s.setMax(10);
    s.setMajorTickUnit(1);
    s.setMinorTickCount(0);
    s.setSnapToTicks(true);
    s.setShowTickLabels(true);
    s.setShowTickMarks(true);

    stage.setScene(new Scene(s));
    stage.show();
}