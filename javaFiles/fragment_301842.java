import java.util.List       ;
import java.util.LinkedList ;
import java.awt.geom.Point2D;
import java.awt.geom.Line2D ;

/**
 * Generates Sierpinski triangle (▲).
 *    
 */
public class Sierpinski
{
    public int width ;
    public int height;
    /**
     * The smallest size of an area of the triangle.
     */
    public int limit ;

    /**
     * Lines of the triangle to be drawn.
     */
    public List<Line2D> lines = new LinkedList<>();

    public Sierpinski(int width, int height, int limit)
    {
        this.width  = width;
        this.height = height;
        this.limit  = limit;
    }

    /**
     * @return triangle area limit
     */
    public int getLimit()
    {
        return limit;
    }

    /**
     * @return width of the Sierpinski triangle
     */
    public int getWidth()
    {
        return width;
    }

    /**
     * @return height of the Sierpinski triangle
     */
    public int getHeight()
    {
        return height;
    }

    /**
     * @return lines of the generated triangles
     */
    public List<Line2D> getLines()
    {
        return lines;
    }

    /**
     * @param p1 Starting point of the line.
     * @param p1 Ending   point of the line.
     */
    public void addLine(Point2D p1, Point2D p2)
    {
        getLines().add(
                new Line2D.Double(p1,p2));
    } 

    /**
     * @param top Top-most point of the triangle.
     * @param left Left-most point of the triangle.
     * @param right Right-most point of the triangle.
     *
     * @return area size of the triangle defined by supplied points.
     */
    public static double triangleArea(Point2D top, Point2D left, Point2D right)
    {
        return Math.abs(top.getX()*(right.getY()-left.getY()) + right.getX()*(left.getY() - top.getY()) + left.getX()*(top.getY()-right.getY())) / 2;
    }

    /**
     * Generates a Sierpinski triangle.
     * @see #generate(Point2D, Point2D)
     */
    public void generate()
    {
        generate(
                new Point2D.Double(getWidth() / 2, 0          ),
                new Point2D.Double(0             , getHeight() - 1 ),
                new Point2D.Double(getWidth() - 1, getHeight() - 1));
    }

    /**
     * Generates a Sierpinski triangle.
     */
    public void generate(Point2D top, Point2D left, Point2D right)
    {
        if (getLimit() < triangleArea(top,left,right)) 
        {
            Point2D leftMiddle   = 
                new Point2D.Double(
                        left.getX() + (top.getX()  - left.getX()) / 2,
                        top.getY()  + (left.getY() - top.getY())  / 2);
            Point2D rightMiddle  = 
                new Point2D.Double(
                        top.getX() + (right.getX() - top.getX()) / 2,
                        leftMiddle.getY());
            Point2D bottomMiddle =
                new Point2D.Double(
                        top.getX() ,
                        left.getY());

            generate(top        , leftMiddle  , rightMiddle );
            generate(leftMiddle , left        , bottomMiddle);
            generate(rightMiddle, bottomMiddle, right       );
        }
        else
        {
            addLine(top , right);
            addLine(top , left );
            addLine(left, right);
        }
    }
}