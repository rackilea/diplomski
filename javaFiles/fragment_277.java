protected JFreeChart createBarChart() throws JRException {
    JFreeChart jfreeChart = super.createBarChart();

    CategoryPlot categoryPlot = (CategoryPlot) jfreeChart.getPlot();
    // categoryPlot.setOrientation(PlotOrientation.HORIZONTAL);
    BarRenderer barRenderer = (BarRenderer) categoryPlot.getRenderer();
    barRenderer.setItemMargin(0);
    barRenderer.setGradientPaintTransformer(new StandardGradientPaintTransformer(GradientPaintTransformType.HORIZONTAL));
    CategoryDataset categoryDataset = categoryPlot.getDataset();
    if (categoryDataset != null) {
        for (int i = 0; i < categoryDataset.getRowCount(); i++) {
            barRenderer.setSeriesPaint(i, ChartThemesConstants.EYE_CANDY_SIXTIES_GRADIENT_PAINTS.get(i));  <-- Here is point
        }
    }
    return jfreeChart;
}