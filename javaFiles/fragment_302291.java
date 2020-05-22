public static double distanceBetween(double x1, double y1, double x2, double y2) {
    double dx = Math.abs(x2-x1);
    double dy = Math.abs(y2-y1); 
    if (dx > dy) {
        double r = dy/dx;
        return dx*Math.sqrt(1.0 + r*r); 
    } else {
        double r = dx/dy;
        return dy*Math.sqrt(1.0 + r*r); 
    }
}