double r = 50.0; // radius (it might radius of your circle, but consider dimensions of rectangle to make sure you are drawing inside of circle, e.g. circleRadius - rectangeDimesion / 2.0)
for (int f = 0; f < 360; f++) {
    double x = Math.sin(Math.toRadians((double)f)) * r;
    double y = Math.cos(Math.toRadians((double)f)) * r;
    // draw rectangle on [x, y] coordinates
}