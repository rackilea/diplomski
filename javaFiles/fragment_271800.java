public class JFreeChartTest extends JFrame {

    private static JFreeChart createPieChart(){
        // Some dataset to display
        DefaultPieDataset data = new DefaultPieDataset();
        data.setValue("Java", new Double(45.0));
        data.setValue("C++", new Double(20.0));
        data.setValue("Visual Basic", new Double(0.0));
        // Chart creation
        return ChartFactory.createPieChart("Pie Chart", // title
                data, // data
                true, // include legend
                true, false);
    }

    public JFreeChartTest(){
        initialize();
    }

    private void initialize(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        JPanel contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);
        {
            final ChartPanel chartPanel = new ChartPanel((JFreeChart)null);
            contentPane.add(chartPanel, BorderLayout.CENTER);
            final JFreeChart pieChart = createPieChart();
            chartPanel.setChart(pieChart);
            chartPanel.addChartMouseListener(new ChartMouseListener() {

                @Override
                public void chartMouseClicked(final ChartMouseEvent event){
                    System.out.println("chartMouseClicked");
                }

                @Override
                public void chartMouseMoved(final ChartMouseEvent event){
                    int newX = event.getTrigger().getX();
                    int newY = event.getTrigger().getY();
                    System.out.println("chartMouseMoved to " + newX + " " + newY);
                }
            });
        }
    }

    public static void main(String[] args){
        JFreeChartTest frame = new JFreeChartTest();
        frame.setVisible(true);
    }
}