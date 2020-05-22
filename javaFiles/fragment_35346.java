chartPanel.addChartMouseListener(new ChartMouseListener() {

    @Override
    public void chartMouseClicked(ChartMouseEvent cme) {
        ChartEntity ce = cme.getEntity();
        if (ce instanceof XYAnnotationEntity) {
            // handle the click
        }
    }
}