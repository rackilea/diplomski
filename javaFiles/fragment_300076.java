private void createGUI() {
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    window = getContentPane();
    gamePanel = new JPanel();
    window.add(gamePanel);
    // This is going to help...
    keyBindings();
}