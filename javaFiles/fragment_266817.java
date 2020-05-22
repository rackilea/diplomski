public class First extends JPanel {

    private static final long serialVersionUID = 4400735172378226919L;

    public First() {
        final DefaultPieDataset dataset = new DefaultPieDataset();

        dataset.setValue("California", new Double(10.0));
        dataset.setValue("Arizona", new Double(8.0));
        dataset.setValue("New Mexico", new Double(8.0));
        dataset.setValue("Texas", new Double(40.0));
        dataset.setValue("Louisiana", new Double(8.0));
        dataset.setValue("Mississippi", new Double(4.0));
        dataset.setValue("Alabama", new Double(2.0));
        dataset.setValue("Florida", new Double(20.0));

        // Create the custom label generator
        final PieSectionLabelGenerator labelGenerator = new StandardPieSectionLabelGenerator("{0} = {1}");

        // Create the charts
        final JFreeChart chart1 = ChartFactory.createPieChart("Driving Time Spent Per State (Flat Pie Chart)", dataset, true, true, false);
        final PiePlot plot1 = (PiePlot) chart1.getPlot();
        plot1.setLabelGenerator(labelGenerator);

        final JFreeChart chart2 = ChartFactory.createPieChart("Driving Time Spent Per State (Exploded Pie Chart)", dataset, true, true, false);
        final PiePlot plot2 = (PiePlot) chart2.getPlot();
        plot2.setExplodePercent("3", 0.25);
        plot2.setLabelGenerator(labelGenerator);

        final JFreeChart chart3 = ChartFactory.createPieChart3D("Driving Time Spent Per State (3D Pie Chart)", dataset, true, true, false);
        final PiePlot3D plot3 = (PiePlot3D) chart3.getPlot();
        plot3.setLabelGenerator(labelGenerator);

        final JFreeChart chart4 = ChartFactory.createPieChart3D("Driving Time Spent Per State (3D with Transparency)", dataset, true, true, false);
        final PiePlot3D plot4 = (PiePlot3D) chart4.getPlot();
        plot4.setForegroundAlpha(0.6f);
        plot4.setLabelGenerator(labelGenerator);

        // Create this panel
        this.setLayout(new GridLayout(2, 2));
        final ChartPanel panel1 = new ChartPanel(chart1);
        final ChartPanel panel2 = new ChartPanel(chart2);
        final ChartPanel panel3 = new ChartPanel(chart3);
        final ChartPanel panel4 = new ChartPanel(chart4);
        this.add(panel1);
        this.add(panel2);
        this.add(panel3);
        this.add(panel4);
    }

    public static void main(final String[] args) {
        final JFrame frame = new JFrame("My Trip Driving From CA to FL...");
        final First chart = new First();
        frame.getContentPane().add(chart, BorderLayout.CENTER);
        frame.setSize(640, 480);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}