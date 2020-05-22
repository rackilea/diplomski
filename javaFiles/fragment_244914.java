PointF center = new PointF(x, y);
final double mult = 1; // mult = 1.1; is more reliable
PointF p1 = calculateDerivedPosition(center, mult * radius, 0);
PointF p2 = calculateDerivedPosition(center, mult * radius, 90);
PointF p3 = calculateDerivedPosition(center, mult * radius, 180);
PointF p4 = calculateDerivedPosition(center, mult * radius, 270);

strWhere =  " WHERE "
        + COL_X + " > " + String.valueOf(p3.x) + " AND "
        + COL_X + " < " + String.valueOf(p1.x) + " AND "
        + COL_Y + " < " + String.valueOf(p2.y) + " AND "
        + COL_Y + " > " + String.valueOf(p4.y);