public class MiniCalculator extends JFrame {

    public static void main(String[] args) {
        new MiniCalculator().setVisible(true);
    }

    private JTextField display = new JTextField(10);

    private JButton clear = new JButton("C");
    private JButton b1 = new JButton("1");
    private JButton b2 = new JButton("2");
    private JButton b3 = new JButton("3");

    public MiniCalculator() {
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(new GridBagLayout());

        GridBagConstraints constraint = new GridBagConstraints();
        constraint.insets = new Insets(5, 5, 5, 5);
        constraint.weighty = 1.0;
        constraint.weightx = 1.0;

        constraint.gridy = 0;
        constraint.gridwidth = 2;
        constraint.fill = GridBagConstraints.HORIZONTAL;
        add(display, constraint);

        constraint.gridwidth = 1;
        constraint.fill = GridBagConstraints.BOTH;
        add(clear, constraint);

        constraint.gridy = 1;
        add(b1, constraint);
        add(b2, constraint);
        add(b3, constraint);

        pack();
        setLocationRelativeTo(null);
    }
}