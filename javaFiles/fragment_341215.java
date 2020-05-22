import java.util.ArrayList;
import java.util.List;
import javafx.geometry.Point2D;
import javafx.scene.shape.Line;

public class DrawGraph {

    private static Point2D start = new Point2D(150,450);
    private static Point2D end = new Point2D(450,150);

    public static void main(String[] args) {
        List<Line> edges = makeEdges(4, start, end);
    }

    /**
     * @param start, end  represent base line
     * @param numberOfLevels  number of levels to build
     * @return a list of all edges.
     */
    private static List<Line> makeEdges(int numberOfLevels, Point2D start, Point2D end){
        List<Line> edges = new ArrayList<>();
        makeEdge(numberOfLevels, start, end, edges);
        return edges;
    }

    //recursive construct edges
    private static void makeEdge( int levels, Point2D start, Point2D end, List<Line> edges) {

        if(levels < 0) return ;
        //add edge to list
        edges.add(new Line(start.getX(), start.getY(), end.getX(), end.getY()));
        //make 2 new points 
        Point2D[] newPoints  = makeNewPoints(start, end);
        //recursive make 4 new lines
        makeEdge(levels - 1, start, newPoints[0],edges);
        makeEdge(levels - 1, newPoints[0], end, edges);
        makeEdge(levels - 1, start, newPoints[1], edges);
        makeEdge(levels - 1, newPoints[1], end, edges);
    }

    //returns 2 new points on the center line of the line represented by start, end
    //the algorithm calculating the new points can be changed as need 
    private static Point2D[] makeNewPoints(Point2D start, Point2D end){

        //edge's mid point
        Point2D midPoint = lineMidPoint(start, end);
        //the inclination angle of the edge
        double angle = lineAngle(start, end);
        //the distance of the 2 new points from the edge. change as needed
        double distance = lineLength(start, midPoint) /4 ; //set to edge length / 4
        //represents the change in x and in y from midpoint to new point
        Point2D deltaXY = newPoint(midPoint, distance, angle);
        //make and return 2 new points
        return new Point2D[]{
                new Point2D(midPoint.getX() + deltaXY.getX(), midPoint.getY() + deltaXY.getY()),
                new Point2D(midPoint.getX() - deltaXY.getX(), midPoint.getY() - deltaXY.getY())
        };
    }

    //mid point between two points
    private static Point2D lineMidPoint(Point2D p1, Point2D p2) {

        return new Point2D((p1.getX() + p2.getX()) /
                2, (p1.getY() + p2.getY()) / 2);
    }

    //angle in radians of a line represented by two points
    private static double lineAngle(Point2D start, Point2D end) {

        double deltaY =  start.getY() - end.getY() ;
        double deltaX =  end.getX()- start.getX()  ;
        return Math.atan2(deltaY, deltaX);
    }

    //length of a line represented by two points
    private static double lineLength(Point2D start, Point2D end) {

        double deltaY = end.getY() - start.getY();
        double deltaX = end.getX() - start.getX();
        return Math.sqrt(deltaY*deltaY + deltaX*deltaX);
    }

    //construct a new point at a distance from point p. angle represents the
    //angle of the line p is on.
    private static Point2D newPoint(Point2D p, double distance, double angle) {

        double deltaY = distance * Math.cos(angle);
        double deltaX = distance * Math.sin(angle);
        return  new Point2D(deltaX, deltaY) ;
    }
}