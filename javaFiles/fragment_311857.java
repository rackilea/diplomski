class GameView {
    private Shape[] shapes;
    private MyKeyListener listener;

    public GameView() {
        shapes[1] = ...;
        shapes[2] = ...;
        listener = new MyKeyListener(shapes);
    }
}