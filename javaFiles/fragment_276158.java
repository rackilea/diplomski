public static void main(String[] args) {

    JFrame frame = new JFrame("Test");
    frame.setLayout(new GridBagLayout());

    GridBagConstraints gbc = new GridBagConstraints();
    gbc.fill = GridBagConstraints.BOTH;
    gbc.weightx = 1;

    frame.add(new JTextArea("Hello World!"), gbc);

    gbc.weightx = 0;
    frame.add(new JButton("Copy"), gbc);
    frame.add(new JButton("Paste"), gbc);

    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.pack();
    frame.setVisible(true);
}