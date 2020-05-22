static double calculateShotAngle(
    double xPT, double yPT, double xVT, double yVT,
    double xPB, double yPB, double bulletS) {
    double gravity = 0.98;
    double angle = null;
    double time = 1; // change this value if needed (try smaller increments if after a single increment the bullet's position will pass the target's position)
    double xPTOriginal = xPt; // Save the initial x position of target
    double yPTOriginal = yPt; // Save the initial y position of target


    while (true) {
        // do Part 1;
        // do Part 2;
        // do Part 3;
        // below code is Part 4
        if (hasBeenHit(xPT, yPT, xPB, yPB)) {
            break;
        } else {
            t++; // increment t
            // Revert the initial position of target
            xPt = xPTOriginal;
            yPt = yPTOriginal;
        }
    }

    return angle;
}

// Method used to check if bullet hits the target
// Method assumes that bullet and target only occupies a point (1 of axis x and 1 of axis y)
static boolean hasBeenHit(double xPT, double yPT, double xPB, double yPB) {
    return xPT == xPB && yPT == yPB;
}