public class Pipe {
    int x;
    int y;
    public class Pipe(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void drawPipe(Graphics g) {
        g.fillRect(x, y, 50, 100);
    }
}