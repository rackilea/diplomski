NumberAxis numberAxis = new NumberAxis();
    LineChart chart = new LineChart(numberAxis, new NumberAxis());
    chart.getYAxis().setSide(Side.RIGHT);
    Node chartPlotArea = chart.lookup(".chart-plot-background");
    chartPlotArea.setStyle("-fx-background-color: cyan");

    Text text = new Text();
    text.setText("Text");


    AnchorPane anchorPane = new AnchorPane();
    AnchorPane.setTopAnchor(chart, 0.0);
    AnchorPane.setRightAnchor(chart, 0.0);
    AnchorPane.setBottomAnchor(chart, 0.0);
    AnchorPane.setLeftAnchor(chart, 0.0);


    anchorPane.getChildren().addAll(chart, text);

    Scene scene = new Scene(anchorPane);
    primaryStage.setScene(scene);
    primaryStage.setMaximized(true);


    primaryStage.show();

        Bounds bounds =
            anchorPane.sceneToLocal(chartPlotArea.localToScene(chartPlotArea.getBoundsInLocal()));

    double textRelativeX = (bounds.getMinX() + bounds.getMaxX()) / 2 - text.getLayoutBounds().getWidth() / 2;
    double textRelativeY = bounds.getMinY() - text.getLayoutBounds().getHeight() / 2;

    AnchorPane.setLeftAnchor(text, textRelativeX);
    AnchorPane.setTopAnchor(text, textRelativeY);