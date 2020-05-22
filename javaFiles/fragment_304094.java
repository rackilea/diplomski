private JFreeChart createChart(TimeTableXYDataset chartData) {
    JFreeChart chart = ChartFactory.createStackedXYAreaChart(
        "Dogs and Cats", "Time", "Count", chartData,
        PlotOrientation.VERTICAL, false, true, false);
    DateAxis dateAxis = new DateAxis();
    dateAxis.setDateFormatOverride(new SimpleDateFormat("HH:mm"));
    dateAxis.setTickLabelFont(dateAxis.getTickLabelFont().deriveFont(20f));
    XYPlot plot = (XYPlot) chart.getPlot();
    plot.setDomainAxis(dateAxis);
    return chart;
}