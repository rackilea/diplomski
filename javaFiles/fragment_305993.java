public Window(int Wwidth, int Wheight, Game game) {
    JFrame Window = new JFrame();
    setPreferredSize(new Dimension(Wwidth, Wheight));
    setMinimumSize(new Dimension(800, 600));
    Window.add(game);
    Window.pack();
    Window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    Window.setTitle("HypoPixel");
    Window.setLocationRelativeTo(null);
    Window.setVisible(true);
    game.start();
}