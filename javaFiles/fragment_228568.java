private StackedBarChart<String, Number> onesecondActiveBarChart = new StackedBarChart<String, Number>(xAxisActive, yAxisActive) {
    @Override
    protected void dataItemAdded(XYChart.Series<String,Number> series, int itemIndex, XYChart.Data<String,Number> item) {
        super.dataItemAdded(series, itemIndex, item);

        Node bar = item.getNode();
        double barVal = item.getYValue().doubleValue();

        if (barVal < 0) {
            bar.getStyleClass().add("negative");
        }   
    }       
};