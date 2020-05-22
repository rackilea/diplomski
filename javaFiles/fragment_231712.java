public class Chart extends Application {

  @Override public void start(Stage stage) {

    final NumberAxis xAxis = new NumberAxis();
    final NumberAxis yAxis = new NumberAxis();
    final LineChart<Number, Number> lineChart = new LineChart<Number, Number>(xAxis, yAxis);

    XYChart.Series series1 = new XYChart.Series();
    series1.setName("green"); //i added name to all series, to find easy in loop
    series1.getData().add(new XYChart.Data(1, 2));
    series1.getData().add(new XYChart.Data(2, 2));
    series1.getData().add(new XYChart.Data(3, 2));
    series1.getData().add(new XYChart.Data(4, 2));
    series1.getData().add(new XYChart.Data(5, 2));

    XYChart.Series series2 = new XYChart.Series();
    series2.setName("yellow");
    series2.getData().add(new XYChart.Data(1, 3));
    series2.getData().add(new XYChart.Data(2, 3));
    series2.getData().add(new XYChart.Data(3, 3));
    series2.getData().add(new XYChart.Data(4, 3));
    series2.getData().add(new XYChart.Data(5, 3));

    XYChart.Series series3 = new XYChart.Series();
    series3.setName("red");
    series3.getData().add(new XYChart.Data(1, 4));
    series3.getData().add(new XYChart.Data(2, 4));
    series3.getData().add(new XYChart.Data(3, 4));
    series3.getData().add(new XYChart.Data(4, 4));
    series3.getData().add(new XYChart.Data(5, 4));

    XYChart.Series series4 = new XYChart.Series();
    series4.setName("blue");
    series4.getData().add(new XYChart.Data(1, 5));
    series4.getData().add(new XYChart.Data(2, 5));
    series4.getData().add(new XYChart.Data(3, 5));
    series4.getData().add(new XYChart.Data(4, 5));
    series4.getData().add(new XYChart.Data(5, 5));

    HBox hbox = new HBox();
    lineChart.getData().addAll(series1, series2, series3, series4);

    //in loop take all series
    for (XYChart.Series<Number, Number> series : lineChart.getData()) {

      if (series.getName().equals("blue")) //if Name is "blue" then continue
        continue;

      //for all series, take date, each data has Node (symbol) for representing point
      for (XYChart.Data<Number, Number> data : series.getData()) {
        // this node is StackPane
        StackPane stackPane = (StackPane) data.getNode();
        stackPane.setVisible(false);
      }
    }

    hbox.getChildren().addAll(lineChart);
    Scene scene = new Scene(hbox, 800, 600);
    scene.getStylesheets().add(getClass().getResource("/resources/chart.css").toExternalForm());
    stage.setScene(scene);
    stage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }
}