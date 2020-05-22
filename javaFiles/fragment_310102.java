private ChartPanel createPane() {
    final XYSeries series = new XYSeries("Data");
    for (int i = 0; i < random.nextInt(N) + N / 2; i++) {
        series.add(i, Math.sin(i));
    }
    XYSeriesCollection dataset = new XYSeriesCollection(series);
    new Timer(1000, new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
            series.add(series.getItemCount(), Math.sin(series.getItemCount()));
        }
    }).start();
    …
}