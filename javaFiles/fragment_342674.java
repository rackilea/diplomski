JFreeChart chart = chartPanel.getChart();
XYPlot plot = (XYPlot) chart.getPlot();
TimeSeriesCollection tsc = (TimeSeriesCollection) plot.getDataset();
XYLineAndShapeRenderer renderer = (XYLineAndShapeRenderer) plot.getRenderer();
for (int i = 0; i < tsc.getSeriesCount(); i++) {
    System.out.println(renderer.lookupSeriesPaint(i));
}