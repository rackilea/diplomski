public class RegressionGUI extends JFrame implements ActionListener {
   private JLabel VariableLabel = new JLabel("Select one independent Variable");
   private JButton X1btn = new JButton("Number of Bathrooms (X1)");
   private JButton X2btn = new JButton("Area of the site (X2)");
   private JButton X3btn = new JButton("Size of living space (X3)");
   private JButton X4btn = new JButton("Number of Garages (X4)");
   private JButton X5btn = new JButton("Number of Rooms (X5)");
   private JButton X6btn = new JButton("Number of bedrooms (X6)");
   private JButton X7btn = new JButton("Age (X7)");
   private JTextArea textArea = new JTextArea();
   private JScrollPane scrollPane = new JScrollPane(textArea);

   // **** added these guys
   private double[] xValues = new double[4];
   private double[] yValues = new double[4];