import java.awt.Color;
import java.awt.Graphics;
import java.awt.geom.Point2D;
import java.util.LinkedList;

public class Snake {

    private final int sSize = 20, startX = 150, startY = 150;
    private final int BLOCK_WIDTH = 4;

    private LinkedList<Point2D.Float> sPoints;

    private boolean isMoving;

    private Direction direction;

    public Snake() {

        sPoints = new LinkedList<Point2D.Float>();

        isMoving = false;

        sPoints.add(new Point2D.Float(startX, startY));

        for (int i = 1; i < sSize; i++) {
            sPoints.add(new Point2D.Float(startX - i * BLOCK_WIDTH, startY));
        }
    }

    public void draw(Graphics g) {

        g.setColor(Color.white);
        for (Point2D p : sPoints) {
            g.fillRect((int) p.getX(), (int) p.getY(), BLOCK_WIDTH, BLOCK_WIDTH);
        }
    }

    public void move() {
        if (isMoving) {
            sPoints.removeLast();
            steer(sPoints.getFirst());
        }
    }

    private void steer(Point2D head) {

        Point2D.Float newHead = new Point2D.Float();
        switch (this.getDirection()) {
        case UP:
            newHead.setLocation(head.getX(), head.getY() - BLOCK_WIDTH);
            break;
        case DOWN:
            newHead.setLocation(head.getX(), head.getY() + BLOCK_WIDTH);
            break;
        case LEFT:
            newHead.setLocation(head.getX() - BLOCK_WIDTH, head.getY());
            break;
        case RIGHT:
            newHead.setLocation(head.getX() + BLOCK_WIDTH, head.getY());
            break;
        }

        this.sPoints.addFirst(newHead);

    }

    public int getX() {
        return (int) sPoints.get(0).getX();
    }

    public int getY() {
        return (int) sPoints.get(0).getY();
    }

    public boolean isMoving() {
        return isMoving;
    }

    public void setIsMoving(boolean b) {
        isMoving = b;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction d) {
        if (this.getDirection() == null) {
            this.direction = d;
        } else if (!this.getDirection().isOpposite(d)) {
            this.direction = d;
        }
    }
}