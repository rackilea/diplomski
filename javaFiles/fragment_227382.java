public class TestLayout extends JFrame {

    private static final long serialVersionUID = -7619921429181915663L;

    public TestLayout(){
        super("TestLayout");
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        init();
    }

    private void init() {
        this.getContentPane().setLayout(new GridBagLayout());

        //Setup some test panel with labels
        JPanel panel1 = new JPanel(new BorderLayout());
        panel1.setBorder(BorderFactory.createEtchedBorder());
        JLabel label1 =  new JLabel("Panel 1");
        label1.setHorizontalAlignment(SwingConstants.CENTER);
        panel1.add(label1,BorderLayout.CENTER);

        JPanel panel2 = new JPanel(new BorderLayout());
        panel2.setBorder(BorderFactory.createEtchedBorder());
        JLabel label2 =  new JLabel("Panel 2");
        label2.setHorizontalAlignment(SwingConstants.CENTER);
        panel2.add(label2,BorderLayout.CENTER);

        JPanel panel3 = new JPanel(new BorderLayout());
        panel3.setBorder(BorderFactory.createEtchedBorder());
        JLabel label3 =  new JLabel("Panel 3");
        label3.setHorizontalAlignment(SwingConstants.CENTER);
        panel3.add(label3,BorderLayout.CENTER);

        JPanel panel4 = new JPanel(new BorderLayout());
        panel4.setBorder(BorderFactory.createEtchedBorder());
        JLabel label4 =  new JLabel("Panel 4");
        label4.setHorizontalAlignment(SwingConstants.CENTER);
        panel4.add(label4,BorderLayout.CENTER);

        //Here goes the interesting code
        this.getContentPane().add(panel1,  new GridBagConstraints(0, 0, 1, 1, 1.0, 0.6, GridBagConstraints.WEST, GridBagConstraints.BOTH, new Insets(2, 2,
                2, 2), 0, 0));
        this.getContentPane().add(panel2,  new GridBagConstraints(1, 0, 1, 1, 1.0, 0.6, GridBagConstraints.WEST, GridBagConstraints.BOTH, new Insets(2, 2,
                2, 2), 0, 0));
        this.getContentPane().add(panel3,  new GridBagConstraints(2, 0, 1, 1, 1.0, 0.6, GridBagConstraints.WEST, GridBagConstraints.BOTH, new Insets(2, 2,
                2, 2), 0, 0));
        //next row
        this.getContentPane().add(panel4,  new GridBagConstraints(0, 1, 3, 1, 1.0, 0.4, GridBagConstraints.WEST, GridBagConstraints.BOTH, new Insets(2, 2,
                2, 2), 0, 0));

        this.setPreferredSize(new Dimension(400, 200));
        this.pack();
    }

    public static void main(String[] args) {
        TestLayout frame = new TestLayout();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}