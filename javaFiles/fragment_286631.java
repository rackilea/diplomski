public GamePanel () {
    this.setTitle("Game");
    this.setSize(screenSize);
    this.setResizable(false);
    this.setVisible(true);  // *****
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    game = new Game(screenSize);
    add(game);
}