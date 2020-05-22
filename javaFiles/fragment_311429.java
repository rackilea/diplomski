public class Position extends JButton {

    private int x;
    private int y;
    private boolean visited = false;

    public Position(int x, int y) {
        super("");
        this.x = x;
        this.y = y;
        this.setPreferredSize(new Dimension(50, 50));
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }


}