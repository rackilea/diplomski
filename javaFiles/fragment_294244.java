NumberAxis domain = new NumberAxis("X");
DateAxis range = new DateAxis("Y");
domain.setAutoRangeIncludesZero(false);
XYItemRenderer renderer = new XYLineAndShapeRenderer(true, false);
XYPlot plot = new XYPlot(dataset, domain, range, renderer);
JFreeChart chart = new JFreeChart(
    "Title", JFreeChart.DEFAULT_TITLE_FONT, plot, false);