public GamePanel () {
    this.setTitle("Game");
    //  this.setSize(screenSize);  // **** don't set sizes like this
    this.setResizable(false);
    // this.setVisible(true);  // *****
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    game = new Game(screenSize);
    add(game);
    pack();  // **** this should size the GUI to the preferred sizes
    setVisible(true); // **** call this here ****
}