public static void main(String[] args) {
    JFrame frame = new JFrame();
    frame.setLayout(new GridBagLayout());
    JPanel panel = new JPanel();
    panel.add(new JLabel("This is a label"));
    panel.setBorder(new LineBorder(Color.BLACK)); // make it easy to see
    frame.add(panel, new GridBagConstraints());
    frame.setSize(400, 400);
    frame.setLocationRelativeTo(null);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
}