public class SliderTime extends Application {
    @Override
    public void start(Stage primaryStage) {
        try {
            HBox root = new HBox();
            Scene scene = new Scene(root,400,400);

            Slider sl = new Slider(0, 3600, 20);
            sl.setMajorTickUnit(450);
            sl.setShowTickLabels(true);
            StringConverter<Double> stringConverter = new StringConverter<>() {

                @Override
                public String toString(Double object) {
                    long seconds = object.longValue();
                    long minutes = TimeUnit.SECONDS.toMinutes(seconds);
                    long remainingseconds = seconds - TimeUnit.MINUTES.toSeconds(minutes);
                    return String.format("%02d", minutes) + ":" + String.format("%02d", remainingseconds);
                }

                @Override
                public Double fromString(String string) {
                    return null;
                }
            };

            sl.setLabelFormatter(stringConverter);

            Text text = new Text();

            sl.valueProperty().addListener((observable, oldValue, newValue) ->
                    text.setText(stringConverter.toString(newValue.doubleValue())));

            root.getChildren().addAll(sl, text);

            primaryStage.setScene(scene);
            primaryStage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}