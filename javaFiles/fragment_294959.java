import java.awt.*;
import java.awt.geom.*;

class PolygonUtil2
{
    public static boolean contains(Polygon polygon, int x, int y)
    {
        System.out.print(x + " : " + y + " - ");

        if (polygon.contains(x, y))
            return true;

        if (polygon.contains(x - 1, y))
            return true;

        if (polygon.contains(x, y - 1))
            return true;

        if (polygon.contains(x - 1, y - 1))
            return true;

        return false;
    }

    public static void main(String...args)
    {
        Polygon polygon=new Polygon();
        polygon.addPoint(10, 10);
        polygon.addPoint(30, 10);
        polygon.addPoint(30, 30);
        polygon.addPoint(10, 30);

        // Test 4 corners

        System.out.println("Corners:");
        System.out.println( PolygonUtil2.contains(polygon, 10, 10) );
        System.out.println( PolygonUtil2.contains(polygon, 30, 10) );
        System.out.println( PolygonUtil2.contains(polygon, 30, 30) );
        System.out.println( PolygonUtil2.contains(polygon, 10, 30) );

        // Test inside/outside left edge

        System.out.println("Left:");
        System.out.println( PolygonUtil2.contains(polygon, 9, 20) );
        System.out.println( PolygonUtil2.contains(polygon, 10, 20) );
        System.out.println( PolygonUtil2.contains(polygon, 11, 20) );

        // Test inside/outside left edge

        System.out.println("Right:");
        System.out.println( PolygonUtil2.contains(polygon, 29, 20) );
        System.out.println( PolygonUtil2.contains(polygon, 30, 20) );
        System.out.println( PolygonUtil2.contains(polygon, 31, 20) );

        // Test above/below top edge

        System.out.println("Top:");
        System.out.println( PolygonUtil2.contains(polygon, 20, 9) );
        System.out.println( PolygonUtil2.contains(polygon, 20, 10) );
        System.out.println( PolygonUtil2.contains(polygon, 20, 11) );

        // Test above/below bottom edge

        System.out.println("Bottom:");
        System.out.println( PolygonUtil2.contains(polygon, 20, 29) );
        System.out.println( PolygonUtil2.contains(polygon, 20, 30) );
        System.out.println( PolygonUtil2.contains(polygon, 20, 31) );
    }
}