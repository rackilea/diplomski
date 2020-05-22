public boolean equals(Object arg) {
    if (arg == null) return false; 
    if (arg == this) return true;
    if (arg instanceof Circle) {
        Circle c = (Circle)arg;
        return radius == c.radius && point.equals(c.point);
    }
    return false;
}