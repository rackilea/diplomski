private class YinYang extends Area {
    public YinYang(Shape shape) {
        super(shape);
    }
}

public Shape moveToAndRotate(double x, double y, double theta)
{
    double cx = getBounds2D().getCenterX();
    double cy = getBounds2D().getCenterY();

    at.translate(cx, cy);
    at.translate(x, y);
    at.rotate(Math.toRadians(theta));
    at.translate(-cx, -cy);
    return at.createTransformedShape(yingYang);
}

YingYang shape = new YingYang(shape.moveToAndRotate(newLoc1.x, newLoc1.y, theta));