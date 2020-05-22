public void initialize(){
    XYChart.Series<Number, Number> series = new XYChart.Series<Number, Number>();
    // add series only once at init
    graph.getData().add(series);

    button.setOnAction(event -> {
        int number1 = Integer.parseInt(number.getText());
        System.out.println(number1);

        // clear current data
        series.getData().clear();

        // add new data
        for (int i = 0; i < number1; i++) {
            series.getData().add(new XYChart.Data(i, i));
        }
    });
}