import java.awt.geom.Point2D;

public class Waypoint extends Point2D.Double{

    private double s;
    private String street;

    public Waypoint(double x, double y, double s, String street) {
        super(x,y);
        s=9;
        street="Street";
    }