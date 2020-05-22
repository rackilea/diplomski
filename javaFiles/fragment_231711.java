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