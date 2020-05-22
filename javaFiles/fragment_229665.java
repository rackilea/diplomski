public class dz extends JFrame {

private JPanel contentPane;

/**
 * Launch the application.
 */
public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
        public void run() {
            try {
                dz frame = new dz();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    });
}

/**
 * Create the frame.
 */
public dz() {
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setBounds(100, 100, 917, 788);
    contentPane = new JPanel();
    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
    setContentPane(contentPane);
    SpringLayout sl_contentPane = new SpringLayout();
    contentPane.setLayout(sl_contentPane);

    // define your data
    double[] x = { 0, 1, 2, 3, 4, 5 };
    double[] y = { 45, 89, 6, 32, 63, 12 };

    // create your PlotPanel (you can use it as a JPanel)
    Plot2DPanel plot = new Plot2DPanel();

    // define the legend position
    plot.addLegend("SOUTH");

    // add a line plot to the PlotPanel
    plot.addLinePlot("my plot", x, y);




    sl_contentPane.putConstraint(SpringLayout.EAST, plot, 600, SpringLayout.WEST, contentPane);
    sl_contentPane.putConstraint(SpringLayout.NORTH, plot, 15, SpringLayout.NORTH, contentPane);
    sl_contentPane.putConstraint(SpringLayout.WEST, plot, 15, SpringLayout.WEST, contentPane);
    sl_contentPane.putConstraint(SpringLayout.SOUTH, plot, 600, SpringLayout.NORTH, contentPane);

/*  panel.setLayout(new GridBagLayout());
    panel.add(plot);
    plot.validate();
    plot.repaint();
    plot.setBounds(50,50,100,100);*/

    contentPane.add(plot);

    JPanel panel = new JPanel();
    panel.setBackground(Color.BLACK);
    sl_contentPane.putConstraint(SpringLayout.NORTH, panel, 20, SpringLayout.NORTH, contentPane);
    sl_contentPane.putConstraint(SpringLayout.WEST, panel, 16, SpringLayout.EAST, plot);
    sl_contentPane.putConstraint(SpringLayout.SOUTH, panel, 408, SpringLayout.NORTH, contentPane);
    sl_contentPane.putConstraint(SpringLayout.EAST, panel, 251, SpringLayout.EAST, plot);
    contentPane.add(panel);


}