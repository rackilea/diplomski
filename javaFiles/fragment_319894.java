public TestLayoutOverlay() {

    setTitle("test");
    setLayout(new GridBagLayout());
    setDefaultCloseOperation(EXIT_ON_CLOSE);

    JLabel background = new JLabel(new ImageIcon("fire.jpg"));
    background.setLayout(new BorderLayout());
    add(background);

    JLabel label = new JLabel("I'm on fire");
    label.setFont(label.getFont().deriveFont(Font.BOLD, 48));
    label.setForeground(Color.WHITE);
    label.setHorizontalAlignment(JLabel.CENTER);
    background.add(label);

    pack();
    setLocationRelativeTo(null);
    setVisible(true);

}