import java.awt.geom.Point2D;

/**
 *
 * @author MT0
 */
public class Circle {
    private Point2D.Double center;
    private double radius;

    public Circle(
            final double x,
            final double y,
            final double r
    ){
      assert( r >= 0 );
      center = new Point2D.Double( x, y );
      radius = r;
    }

    public Point2D.Double getCenter(){
        return center;
    }

    public double getRadius(){
        return radius;
    }

    public Double distance( final Point2D.Double point ){
        if ( point == null )
            return null;
        return getCenter().distance( point );
    }

    public boolean contains( final Point2D.Double point ){
        if ( point == null )
            return false;
        return distance( point ) <= getRadius();
    }

    public boolean overlaps( final Circle c ){
        return distance( c.getCenter() ) <= getRadius() + c.getRadius();
    }

    public boolean contains( final Circle c ){
        if ( c == null )
            return false;
        return distance( c.getCenter() ) <= Math.abs( getRadius() - c.getRadius() );
    }
}