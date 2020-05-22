public class Arc extends Curve {    
    @Override
    public Point[] intersection(Curve c) {
        if (c instanceof Line)
            return instersection ((Line) c);
        else if (c instanceof Arc)
            return intersection ((Arc) c);
        else
            return an empty array or null, or throw some exception
    }

    public Point[] intersection(Line l) {
        // return intersection Point(s) of this and l
    }

    public Point[] intersection(Arc a) {
        // returns intersection Point(s)
    }
}