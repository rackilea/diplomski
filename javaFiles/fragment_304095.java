private JFreeChart createChart(TimeTableXYDataset chartData) {
    DateAxis dateAxis = new DateAxis("Time");
    dateAxis.setDateFormatOverride(new SimpleDateFormat("HH:mm"));
    dateAxis.setTickLabelFont(dateAxis.getTickLabelFont().deriveFont(20f));
    NumberAxis yAxis = new NumberAxis("Count");
    XYToolTipGenerator toolTipGenerator = new StandardXYToolTipGenerator();
    StackedXYAreaRenderer2 renderer = new StackedXYAreaRenderer2(
        toolTipGenerator, null);
    renderer.setOutline(true);
    XYPlot plot = new XYPlot(chartData, dateAxis, yAxis, renderer);
    plot.setOrientation(PlotOrientation.VERTICAL);
    plot.setRangeAxis(yAxis);  // forces recalculation of the axis range
    JFreeChart chart = new JFreeChart("Dogs and Cats",
        JFreeChart.DEFAULT_TITLE_FONT, plot, false);
    new StandardChartTheme("JFree").apply(chart);
    return chart;
}