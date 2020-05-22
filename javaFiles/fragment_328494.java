import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;

public class SimpleCell {
    private static final Color CELL_COLOR = Color.RED;
    private boolean alive = false;
    private int x;
    private int y;
    private int width;
    private Rectangle rectangle;

    public SimpleCell(int x, int y, int width) {
        this.x = x;
        this.y = y;
        this.width = width;
        rectangle = new Rectangle(x, y, width, width);
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public void draw(Graphics2D g2) {
        if (alive) {
            g2.setColor(CELL_COLOR);
            g2.fill(rectangle);
        }
    }

    public boolean contains(Point p) {
        return rectangle.contains(p);
    }

    @Override
    public String toString() {
        return "SimpleCell [alive=" + alive + ", x=" + x + ", y=" + y + ", width=" + width + ", rectangle=" + rectangle
                + "]";
    }

}