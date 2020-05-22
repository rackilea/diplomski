public static void main(String[] args) {
    JFrame frame = new JFrame("Testing MigLayout");
    JPanel contentPane = new JPanel(new MigLayout("fillx"));

    // Row 1
    JLabel areaLabel = new JLabel("Area of Triangle");
    areaLabel.setFont(areaLabel.getFont().deriveFont(16.0f));
    areaLabel.setHorizontalAlignment(JLabel.CENTER);
    contentPane.add(areaLabel, "spanx, growx, wrap");
    // wrap indicates a new row

    // Row 2
    JLabel side1Label = new JLabel("Side 1:");
    contentPane.add(side1Label, "alignx trailing");
    JTextField side1Field = new JTextField();
    side1Field.setColumns(6);
    contentPane.add(side1Field, "alignx leading, wrap");

    // Row 3
    JLabel side2Label = new JLabel("Side 2:");
    contentPane.add(side2Label, "alignx trailing");
    JTextField side2Field = new JTextField();
    side2Field.setColumns(6);
    contentPane.add(side2Field, "alignx leading, wrap");

    // Row 4
    JLabel side3Label = new JLabel("Side 3:");
    contentPane.add(side3Label, "alignx trailing");
    JTextField side3Field = new JTextField();
    side3Field.setColumns(6);
    contentPane.add(side3Field, "alignx leading, wrap");

    // Row 5
    JButton calculateButton = new JButton("Calculate Area");
    contentPane.add(calculateButton, "spanx, growx");

    frame.setContentPane(contentPane);
    // Resizes automatically
    frame.pack();
    // Centers automatically
    frame.setLocationRelativeTo(null);
    // Exit when the frame is closed
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    frame.setVisible(true);
}