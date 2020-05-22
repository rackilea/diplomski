protected Point pointOnCircle() {

    double rads = Math.toRadians(orbitAngle - 180); // Make 0 point out to the right...
    int fullLength = Math.round((outterRadius));

    // Calculate the outter point of the line
    int xPosy = Math.round((float) (Math.cos(rads) * fullLength));
    int yPosy = Math.round((float) (Math.sin(rads) * fullLength));

    return new Point(xPosy, yPosy);
}