import java.awt.Point;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class SortPointsByAngle
{
    public static void main(String[] args)
    {
        Point center = new Point(2,2);
        List<Point> points = new ArrayList<Point>();
        points.add(new Point(0, 4));
        points.add(new Point(2, 4));
        points.add(new Point(2, 3));
        points.add(new Point(4, 3));
        points.add(new Point(3, 0));
        points.add(new Point(1, 1));

        List<Point> copy = new ArrayList<Point>(points);
        Collections.shuffle(copy, new Random(0));

        System.out.println("shuffled : "+stringFor(copy));
        Collections.sort(copy, 
            Collections.reverseOrder(byAngleComparator(center)));
        System.out.println("sorted   : "+stringFor(copy));
        System.out.println("reference: "+stringFor(points));
    }

    private static String stringFor(List<Point> points)
    {
        StringBuilder sb = new StringBuilder();
        boolean first = true;
        for (Point p : points)
        {
            if (!first)
            {
                sb.append(",");
            }
            first = false;
            sb.append("("+p.x+","+p.y+")");
        }
        return sb.toString();
    }

    /**
     * Creates a comparator that compares points by the angle that the line
     * between the given center and the point has to the x-axis.
     * 
     * @param center The center
     * @return The comparator
     */
    public static Comparator<Point2D> byAngleComparator(
        Point2D center)
    {
        final double centerX = center.getX();
        final double centerY = center.getY();
        return new Comparator<Point2D>()
        {
            @Override
            public int compare(Point2D p0, Point2D p1)
            {
                double angle0 = angleToX(
                    centerX, centerY, p0.getX(), p0.getY());
                double angle1 = angleToX(
                    centerX, centerY, p1.getX(), p1.getY());
                return Double.compare(angle0, angle1);
            }
        };
    }

    /**
     * Computes the angle, in radians, that the line from (x0,y0) to (x1,y1) 
     * has to the x axis
     * 
     * @param x0 The x-coordinate of the start point of the line
     * @param y0 The y-coordinate of the start point of the line
     * @param x1 The x-coordinate of the end point of the line
     * @param y1 The y-coordinate of the end point of the line
     * @return The angle, in radians, that the line has to the x-axis
     */
    private static double angleToX(
        double x0, double y0, double x1, double y1)
    {
        double dx = x1 - x0;
        double dy = y1 - y0;
        double angleRad = Math.atan2(dy, dx); 
        return angleRad;
    }
}