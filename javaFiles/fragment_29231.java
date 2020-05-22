public class MyClass implements MouseListener {
    private GLWindow window;
    private int centeredX = -1;
    private int centeredY = -1;

    // ...

    public void mouseMoved(MouseEvent e) {
        if (centeredX == -1 || centeredY == -1) {
            center();
            return;
        }

        int deltaX = e.getX() - centeredX;
        int deltaY = e.getY() - centeredY;

        // ... Do something with the deltas

        centeredX = window.getWidth() / 2;
        centeredY = window.getHeight() / 2;
        window.warpPointer(centeredX, centeredY);
    }
}