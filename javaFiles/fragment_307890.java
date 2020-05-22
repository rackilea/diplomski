public class ChartPanelTest {

    private static final int N = 64;
    private static final int SIZE = 400;
    private static final Random random = new Random();

    private static XYDataset createDataset() {

        final TimeSeries series = new TimeSeries("Random Data");
        Day current = new Day();
        for (int i = 0; i < N; i++) {
            series.add(current, random.nextGaussian());
            current = (Day) current.next();
        }
        return new TimeSeriesCollection(series);
    }

    private static JFreeChart createChart(final XYDataset dataset) {
        JFreeChart chart = ChartFactory.createTimeSeriesChart(
            "Test", "Day", "Value", dataset, false, false, false);
        return chart;
    }

    public static void main(String[] args) {

        JFrame f = new JFrame();
        f.setLayout(new GridLayout(1, 0));
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JFreeChart chart = createChart(createDataset());
        f.add(new JScrollPane(new JPanel() {

            {
                setBackground(Color.red);
            }

            @Override
            public Dimension getPreferredSize() {
                return new Dimension(SIZE, SIZE);
            }
        }));
        f.add(new ChartPanel(chart) {

            @Override
            public Dimension getPreferredSize() {
                return new Dimension(SIZE, SIZE);
            }
        });
        f.pack();
        f.setSize(2 * (SIZE - N), SIZE - N);
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }
}