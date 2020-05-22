package serialize2d;

import java.util.Arrays;

/** PathSegment bean stores the detail on one segment of the path
 that constitutes a Shape. */
public class PathSegment {

    public int pathSegmentType;
    public int windingRule;
    public double[] coords;

    public PathSegment() {}

    public PathSegment(int pathSegmentType, int windingRule, double[] coords) {
        this.pathSegmentType = pathSegmentType;
        this.windingRule = windingRule;
        this.coords = coords;
    }

    public int getPathSegmentType() {
        return pathSegmentType;
    }

    public void setPathSegmentType(int pathSegmentType) {
        this.pathSegmentType = pathSegmentType;
    }

    public int getWindingRule() {
        return windingRule;
    }

    public void setWindingRule(int windingRule) {
        this.windingRule = windingRule;
    }

    public double[] getCoords() {
        return coords;
    }

    public void setCoords(double[] coords) {
        this.coords = coords;
    }

    @Override
    public String toString() {
        String sC = (coords != null ? "" : Arrays.toString(coords));
        String s = String.format(
                "PathSegment: Path Segment Type:- %d \t"
                + "Winding Rule:- %d \tcoords:- %s",
                getPathSegmentType(), getWindingRule(), sC);
        return s;
    }
}