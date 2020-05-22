private ChartPanel createPane(String title) {
    TimeSeriesCollection dataset = new TimeSeriesCollection(all.getSeries(title));
    JFreeChart chart = ChartFactory.createXYBarChart(…. dataset. …);
    // decorate chart
    return new ChartPanel(chart);
}