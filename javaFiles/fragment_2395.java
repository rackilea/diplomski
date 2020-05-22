public void drawOrbitingSphere(int timeInterval) {

    // let's just choose a bunch of values that we'll need
    double orbitX = 100; /* x-coordinate in orbit's center */
    double orbitY = 100; /* y-coordinate in orbit's center */
    double orbitRadius = 50;
    double orbitSpeed = Math.PI / 16;
    double sphereRadius = 10;

    /*
     * based on the current time interval, we'll calculate where the sphere
     * is at on its orbit
     */
    double radian = orbitSpeed * timeInterval;
    double drawX = orbitX + orbitRadius * Math.cos(radian);
    double drawY = orbitY + orbitRadius * Math.sin(radian);

    // use whichever Draw method is provided by your API
    drawSphere(drawX, drawY, sphereRadius);
}