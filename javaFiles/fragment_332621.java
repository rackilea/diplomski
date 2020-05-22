IPoint centroid, bottomLeft, topLeft, topRight, bottomRight;

public Rectangle(IPoint v0, IPoint v1) {
    IPoint bottomLeft = new Point(Math.min(v0.x(), v1.x()), Math.min(v0.y(), v1.y()));
    IPoint topRight   = new Point(Math.max(v0.x(), v1.x()), Math.max(v0.y(), v1.y()));

    // calculate dominant length
    double dx = topRight.x() - bottomLeft.x();
    double dy = topRight.y() - bottomLeft.y();  // Assumes (0, 0) is in the bottom-left.
    double dl = dx >= dy ? dx : dy;

    this.centroid = bottomLeft.midPoint(topRight);
    if (dx == dy)  // special case where it is square <- important, because this one fixes the errors
    {
        this.bottomLeft = bottomLeft;
        this.topLeft = new Point(bottomLeft.x(), topRight.y());
        this.topRight = topRight;
        this.bottomRight = new Point(topRight.x(), bottomLeft.y());
    }
    else if (dx >= dy) {
        // this way bottomLeft and topRight are always on the vertical boundaries
        this.bottomLeft  = new Point(bottomLeft.x(), this.centroid.y() - dl / 2);
        this.topLeft     = new Point(bottomLeft.x(), this.centroid.y() + dl / 2);
        this.bottomRight = new Point(topRight.x(), this.centroid.y() - dl / 2);
        this.topRight    = new Point(topRight.x(), this.centroid.y() + dl / 2);
    } else {
        // this way bottomLeft and topRight are always on the horizontal boundaries
        this.bottomLeft  = new Point(this.centroid.x() - dl / 2, bottomLeft.y());
        this.topLeft     = new Point(this.centroid.x() - dl / 2, topRight.y());
        this.bottomRight = new Point(this.centroid.x() + dl / 2, bottomLeft.y());
        this.topRight    = new Point(this.centroid.x() + dl / 2, topRight.y());
    }
}