ChartPanel chartPanel1 = createDemoPanel("Chart1");
ChartPanel chartPanel2 = createDemoPanel("Chart2");
XYPlot plot1 = chartPanel1.getChart().getXYPlot();
XYPlot plot2 = chartPanel2.getChart().getXYPlot();
plot2.setDomainAxis(plot1.getDomainAxis());
chartPanel1.setLayout(new GridLayout());
chartPanel2.setLayout(new GridLayout());
JSplitPane splitPane = new JSplitPane(
    JSplitPane.VERTICAL_SPLIT, chartPanel1, chartPanel2);
add(splitPane, BorderLayout.CENTER);