package twoBalls;

import java.awt.Color;
import java.awt.Point;

public class Ball {

    private final int radius;

    private final Color color;

    private final Point center;

    public Ball(int x, int y, int radius, Color color) {
        this(new Point(x, y), radius, color);
    }

    public Ball(Point center, int radius, Color color) {
        this.center = center;
        this.radius = radius;
        this.color = color;
    }

    public int getRadius() {
        return radius;
    }

    public Color getColor() {
        return color;
    }

    public Point getCenter() {
        return center;
    }

}