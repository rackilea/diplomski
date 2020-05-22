public static void main(String[] args) {
    Shape[] shapes = new Shape[5];;
    shapes[1] = ...;
    shapes[2] = ...;
    GameView view = new GameView(shapes);
    MyKeyListener listener = new MyKeyListener(shapes);
}