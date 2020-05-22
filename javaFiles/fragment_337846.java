public Game() {
    Dimension size = new Dimension(WIDTH * SCALE, HEIGHT * SCALE);
    setPreferredSize(size);

    screen = new Screen(WIDTH, HEIGHT);
    frame = new JFrame();
    input = new InputHandler(player);//pass player object as argument

    addKeyListener(input);
    setFocusable(true);
}