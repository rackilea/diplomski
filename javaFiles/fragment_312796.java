private Point2D.Float calculateDeflection(float x, float y) {
    Point2D.Float center = new Point2D.Float(0, 0);
    Point2D.Float joyPoint = new Point2D.Float(x, y);
    Double angleRad = Math.atan2(y, x);

    float maxDist = getMaxDist(joyPoint);

    float factor = (maxDist - deadzone) / maxDist;

    Point2D.Float factoredPoint = new Point2D.Float(x * factor, y * factor);

    float factoredDist = (float) center.distance(factoredPoint);

    float finalDist = factoredDist + deadzone;

    float finalX = finalDist * (float) Math.cos(angleRad);
    float finalY = finalDist * (float) Math.sin(angleRad);

    Point2D.Float finalPoint = new Point2D.Float(finalX, finalY);

    return finalPoint;
}