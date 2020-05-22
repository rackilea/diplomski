public Pong() {
    setSize(800, 800);
    setFocusable(true);
    Container cp = getContentPane();
    cp.setLayout(new FlowLayout());
    cp.add(gamePanel);
    cp.add(buttons);
    setVisible(true);
}