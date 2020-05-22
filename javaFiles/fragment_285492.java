addButton.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        int n = dataset.getSeriesCount();
        dataset.addSeries("Series" + n, createSeries(n));
        XYPlot plot = chart.getXYPlot();
        XYItemRenderer renderer = plot.getRenderer();
        System.out.println(renderer.isSeriesVisible(n));
    }
});