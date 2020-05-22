public Point GetRotatedRecPoint(int degree, int cubeSize, Point centerPoint) {
    degree = 360 - degree;
    float length = (float) Math.sqrt(((cubeSize/2)*(cubeSize/2)) + ((cubeSize/2)*(cubeSize/2)));
    float x = Math.cos(Math.toRadians(degree));
    float y = Math.sin(Math.toRadians(degree))
    return new Point(x*length + centerPoint.x, y*length + centerPoint.y);
}