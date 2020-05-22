package twoBalls;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

public class GUIModel {

    private double direction;
    private double distance;

    private List<Ball> balls;

    private Point lineStartPoint;
    private Point lineEndPoint;

    public GUIModel() {
        this.balls = new ArrayList<>();
    }

    public void addBall(Ball ball) {
        this.balls.add(ball);
    }

    public List<Ball> getBalls() {
        return balls;
    }

    public void calculatePoints() {
        this.lineStartPoint = balls.get(0).getCenter();
        this.lineEndPoint = balls.get(1).getCenter();

        this.distance = Point.distance(lineStartPoint.x, lineStartPoint.y,
                lineEndPoint.x, lineEndPoint.y);
        this.direction = Math.atan2(lineEndPoint.y - lineStartPoint.y,
                lineEndPoint.x - lineStartPoint.x);
    }

    public Point getCurrentPoint(int pos, int total) {
        double increment = distance / total;
        double length = increment * pos;

        double x = lineStartPoint.x + Math.cos(direction) * length;
        double y = lineStartPoint.y - Math.sin(direction) * length;

        x = Math.round(x);
        y = Math.round(y);

        return new Point((int) x, (int) y);
    }

    public Point getLineStartPoint() {
        return lineStartPoint;
    }

}