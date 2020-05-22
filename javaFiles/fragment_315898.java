public static Point2D.Double calcAngle(Point.Double p1, Point.Double p2){
    double xDiff = p2.x - p1.x;
    double yDiff = p2.y - p1.y;
    return new Point2D.Double(xDiff,yDiff);
}


public class EntityFireball extends Entity {
    private Point2D.Double course;
    private double speed;
    private int life;

    public EntityFireball(double x, double y, double angle, Point2D.Double course){
        super(x, y, 20, 20);
        this.angle = angle;
        this.course=course;
    }

    public void update(boolean inRange){
        life++;
        if(life>2500)
            removeEntityFromGame(this);

        if(inRange){
            float xDirection = course.x;
            float yDirection = course.y;
            double newX = getX() + xDirection;
            double newY = getY() + yDirection;
            setX(newX);
            setY(newY);
        }
    }
}