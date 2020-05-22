private PointF getPosition(PointF center, float radius, float angle) {

    PointF p = new PointF((float) (center.x + radius * Math.cos(Math.toRadians(angle))),
    (float) (center.y + radius* Math.sin(Math.toRadians(angle))));

    return p;
}