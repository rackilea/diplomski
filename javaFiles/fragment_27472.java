XYPlot plot = (XYPlot) chart.getPlot();
plot.setRenderer(new MyRenderer());
...
private static class MyRenderer extends XYLineAndShapeRenderer {

    @Override
    public LegendItem getLegendItem(int dataset, int series) {
        LegendItem legendItem = super.getLegendItem(dataset, series);
        System.out.println(dataset + " " + series + " " + legendItem.getShape());
        // modify legendItem here
        return legendItem;
    }
}