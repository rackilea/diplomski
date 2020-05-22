public void renderChart(ArrayList<NabDetail> listData) {
    // Clear your previous chart DataSet and Renderer.
    mDataSet.clear();
    mRenderer = new XYMultipleSeriesRenderer();

    String seriesTitle = "";
    XYSeries series = new XYSeries(seriesTitle);
    mDataset.addSeries(series);
    mCurrentSeries = series;
    XYSeriesRenderer renderer = new XYSeriesRenderer();
    renderer.setFillBelowLine(true);
    renderer.setFillBelowLineColor(Color.TRANSPARENT);
    renderer.setColor(Color.YELLOW);
    mRenderer.addSeriesRenderer(renderer);
    mRenderer.setInScroll(true);
    mRenderer.setShowLegend(false);
    //hide x label
    mRenderer.setXLabels(RESULT_OK);
    renderer.setFillPoints(true);
    mCurrentRenderer = renderer;

    for (int i = 0; i < listData.size(); i++) {
        mCurrentSeries.add(i,listData.get(i).getInuNilai());
    }

    // repaint your chart with new mDataSet and mRenderer.
    repaint();
}

private void repaint() {
    lnChart = (LinearLayout) findViewById(R.id.chart);

    if (mChartView != null) {
        lnChart.removeView(mChartView);
    }

    mChartView = ChartFactory.getLineChartView(this, mDataset, mRenderer);

    lnChart.addView(mChartView, 0, new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
}