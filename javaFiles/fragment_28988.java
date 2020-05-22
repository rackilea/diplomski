class LineIntersectException extends Exception
{
    LineIntersectException(String message)
    {
        super(message);
    }
}

public static Point intersect(Line line1, Line line2)
{
    if(line1.m == line2.m)
    {
        throw new LineIntersectException("The two lines don't intersect");
    }

    double x = (line1.c - line2.c) / (line1.m - line2.m);
    double y = this.m * x + this.b;

    return new Point(x, y);
}