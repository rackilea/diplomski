ChartPanel piePanel = new ChartPanel(lineChart) {
    @Override
    public Dimension getPreferredSize() {
        return new Dimension(640, 480);
    }
};