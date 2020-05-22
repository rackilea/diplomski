package serialize2d;

import java.awt.geom.*;
import java.util.ArrayList;

/** PathBean stores the collection of PathSegment objects
 that constitute the path of a Shape. */
public class PathBean {

    public ArrayList<PathSegment> pathSegments;

    public PathBean() {}

    public PathBean(ArrayList<PathSegment> pathSegments) {
        this.pathSegments = pathSegments;
    }

    public ArrayList<PathSegment> getPathSegments() {
        return pathSegments;
    }

    public void setPathSegments(ArrayList<PathSegment> pathSegments) {
        this.pathSegments = pathSegments;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        for (PathSegment pathSegment : pathSegments) {
            sb.append(" \n\t");
            sb.append(pathSegment.toString());
        }
        sb.append(" \n");
        sb.append("}");
        return "PathSegments: " + sb.toString();
    }
}