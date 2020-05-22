private static int[] COLORS = new int[] { Color.GREEN, Color.BLUE,Color.MAGENTA, Color.CYAN }; 

private GraphicalView createPieChart(ArrayList<Integer> data){
    GraphicalView chartView;
    CategorySeries series = new CategorySeries("PIE");

    for (int i = 0; i < VALUES.length; i++) {  
        series.add(i, data.get(i));  
        SimpleSeriesRenderer renderer = new SimpleSeriesRenderer();  
        renderer.setColor(COLORS[(series.getItemCount() - 1) % COLORS.length]);  
        mRenderer.addSeriesRenderer(renderer);  
    } 

    chartView = ChartFactory.getPieChartView(this, series, new DefaultRenderer());
    chartView.repaint();
    return chartView;
}