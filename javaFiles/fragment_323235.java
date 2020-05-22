public boolean isParallelTo (Segment other) {
    double otherSlope = other.point1.slopeTo(other.point2);
    double thisSlope = point1.slopeTo(point2);

    return otherSlope == thisSlope;
}