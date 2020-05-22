private void createChartPanel() {
    …
    JFreeChart chart = new JFreeChart("BoxAndWhiskerDemo", plot);
    LegendTitle legend = chart.getLegend();
    legend.setFrame(new LineBorder(Color.white, new BasicStroke(1.0f),
        new RectangleInsets(1.0, 1.0, 1.0, 1.0)));
    legend.setItemFont(legend.getItemFont().deriveFont(16f));
    chartPanel = new ChartPanel(chart);
}