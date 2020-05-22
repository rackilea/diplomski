@FXML
public void updateChart() {     
    XYChart.Series<Number, Number> series = getSeries();
    chart.getData().clear();
    chart.getData().add(series);
}