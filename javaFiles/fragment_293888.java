public static double angleBetween2Lines(Line2D line1, Line2D line2)
{
    double angle1 = Math.atan2(line1.getY1() - line1.getY2(),
                           line1.getX1() - line1.getX2());
    double angle2 = Math.atan2(line2.getY1() - line2.getY2(),
                           line2.getX1() - line2.getX2());
    return angle1-angle2;
}