public static void main(String[] args) {
    PrepareChart prepareChart = new PrepareChart();
    JFrame frame = new JFrame();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.add(prepareChart.getChartPanel());
    frame.pack();
    frame.setVisible(true);
}