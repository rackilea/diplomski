panel.addChartMouseListener(new ChartMouseListener() {

    private Comparable lastKey;

    @Override
    public void chartMouseMoved(ChartMouseEvent e) {
        ChartEntity entity = e.getEntity();
        if (entity instanceof PieSectionEntity) {
            PieSectionEntity section = (PieSectionEntity) entity;
            PiePlot plot = (PiePlot) chart.getPlot();
            if (lastKey != null) {
                plot.setExplodePercent(lastKey, 0);
            }
            Comparable key = section.getSectionKey();
            plot.setExplodePercent(key, 0.10);
            lastKey = key;
        }
    }

    @Override
    public void chartMouseClicked(ChartMouseEvent e) {
    }
});