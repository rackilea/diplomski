public JPanel getChartPanel() {

    EventQueue.invokeLater(new Runnable() {
        @Override
        public void run() {
            start();
        }
    });
    return new ChartPanel(chart);
}