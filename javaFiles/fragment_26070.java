public static <S, T> XYChart.Series<S, T> copySeries(XYChart.Series<S, T> series) {
    XYChart.Series<S, T> copy = new XYChart.Series<>(series.getName(),
            series.getData().stream()
                  .map(data -> new XYChart.Data<S, T>(data.getXValue(), data.getYValue()))
                  .collect(Collectors.toCollection(FXCollections::observableArrayList)));
    return copy;
}