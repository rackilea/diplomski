public static PointF getRotatedPoint(PointF pt,PointF center, float degrees)
{
    double x0 = pt.x;
    double y0 = pt.y;
    double angleInRadians = degrees * (Math.PI / 180);
    pt.x = (float) (Math.cos(angleInRadians) * (x0-center.x) - Math.sin(angleInRadians) * (y0-center.y) + center.x);
    pt.y = (float) (Math.sin(angleInRadians) * (x0-center.x) + Math.cos(angleInRadians) * (y0-center.y) + center.y);
    return pt;
}