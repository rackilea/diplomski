public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        NumberAxis numberAxis = new NumberAxis();
        LineChart<Number, Number> chart = new LineChart<>(numberAxis, new NumberAxis());
        chart.getYAxis().setSide(Side.RIGHT);

        AnchorPane buffer = new AnchorPane();
        buffer.setStyle("-fx-background-color: gray;" +
                "-fx-opacity: 0.5");

        AnchorPane anchorPane = new AnchorPane();
        AnchorPane.setTopAnchor(chart, 0.0);
        AnchorPane.setRightAnchor(chart, 0.0);
        AnchorPane.setBottomAnchor(chart, 0.0);
        AnchorPane.setLeftAnchor(chart, 0.0);

        anchorPane.getChildren().addAll(chart, buffer);

        Scene scene = new Scene(anchorPane);
        primaryStage.setScene(scene);
        primaryStage.setMaximized(true);

        primaryStage.show();

        resetBuffer(chart, buffer, anchorPane,scene);



    }

    private void resetBuffer(LineChart<Number, Number> chart, AnchorPane buffer,
                             AnchorPane anchorPane,Scene scene) {
        Node chartPlot = chart.lookup(".chart-plot-background");

        Bounds bounds = anchorPane.sceneToLocal(
                chartPlot.localToScene(chartPlot.getBoundsInLocal()));

        buffer.setPrefWidth(bounds.getWidth());
        buffer.setPrefHeight(bounds.getHeight());

        AnchorPane.setLeftAnchor(buffer, bounds.getMinX());
        AnchorPane.setTopAnchor(buffer, bounds.getMinY());

        scene.widthProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                double dif =oldValue.doubleValue()-newValue.doubleValue();
                buffer.setPrefWidth(buffer.getWidth()-(dif));
            }
        });
        scene.heightProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                double dif =oldValue.doubleValue()-newValue.doubleValue();
                buffer.setPrefHeight(buffer.getHeight()-(dif));
            }
        });

    }
}