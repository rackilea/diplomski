package serialize2d;

import java.awt.Shape;
import java.awt.geom.*;
import java.util.ArrayList;

/** Utility class to convert bean to/from a Shape. */
public class BeanConverter {

    /** Convert a shape to a serializable bean.  */
    public static ArrayList<PathSegment> getSegmentsFromShape(Shape shape) {
        ArrayList<PathSegment> shapeSegments = new ArrayList<PathSegment>();
        for (
                PathIterator pi = shape.getPathIterator(null); 
                !pi.isDone(); 
                pi.next()) {
            double[] coords = new double[6];
            int pathSegmentType = pi.currentSegment(coords);
            int windingRule = pi.getWindingRule();
            PathSegment as = new PathSegment(
                    pathSegmentType, windingRule, coords);
            shapeSegments.add(as);
        }
        return shapeSegments;
    }

    /** Convert a serializable bean to a shape.  */
    public static Shape getShapeFromSegments(PathBean shapeSegments) {
        GeneralPath gp = new GeneralPath();
        for (PathSegment shapeSegment : shapeSegments.getPathSegments()) {
            double[] coords = shapeSegment.getCoords();
            int pathSegmentType = shapeSegment.getPathSegmentType();
            int windingRule = shapeSegment.getWindingRule();
            gp.setWindingRule(windingRule);
            if (pathSegmentType == PathIterator.SEG_MOVETO) {
                gp.moveTo(coords[0], coords[1]);
            } else if (pathSegmentType == PathIterator.SEG_LINETO) {
                gp.lineTo(coords[0], coords[1]);
            } else if (pathSegmentType == PathIterator.SEG_QUADTO) {
                gp.quadTo(coords[0], coords[1], coords[2], coords[3]);
            } else if (pathSegmentType == PathIterator.SEG_CUBICTO) {
                gp.curveTo(
                        coords[0], coords[1], coords[2], 
                        coords[3], coords[4], coords[5]);
            } else if (pathSegmentType == PathIterator.SEG_CLOSE) {
                gp.closePath();
            } else {
                System.err.println("Unexpected value! " + pathSegmentType);
            }
        }
        return gp;
    }
}