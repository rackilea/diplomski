public TestLayoutOverlay() throws IOException { // Extends JFrame...

    setTitle("test");
    setLayout(new GridBagLayout());
    setDefaultCloseOperation(EXIT_ON_CLOSE);

    PaintPane pane = new PaintPane(ImageIO.read(new File("fire.jpg")));
    pane.setLayout(new BorderLayout());
    add(pane);

    JLabel label = new JLabel("I'm on fire");
    label.setFont(label.getFont().deriveFont(Font.BOLD, 48));
    label.setForeground(Color.WHITE);
    label.setHorizontalAlignment(JLabel.CENTER);
    pane.add(label);

    pack();
    setLocationRelativeTo(null);
    setVisible(true);

}