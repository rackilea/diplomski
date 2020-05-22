private JFrame frame;

public static void main(String[] args) {
    SwingUtilities.invokeLater(new FunnyClown()::createAndShowGui);
}

private void createAndShowGui() {
    frame = new JFrame(getClass().getSimpleName());

    this.setOpaque(true);
    frame.add(this);
    frame.pack();
    frame.setVisible(true);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}