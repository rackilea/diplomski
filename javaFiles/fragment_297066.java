public void calculate() {
    // Center of circle is at (250, 250). Radius is 40.
    //THIS ALGORITHM IS PROVEN TO BE BETTER THAN I FEARED...

    /*      What it does:
     *          Moves object around in a circle, if object is 
     *              inside of circle.
     *          Does not move the object towards the center, 
     *              nor outwards. This is crucial.
     *          Object always stays on the rim of the circle, 
     *              if the collision detection allows it to.
     * 
     *      Algorithm I used. (DOES WORK, NOT EXPECTING THIS THOUGH.):
     *          N is normalized vector. 
     *          R = -2*(V dot N)*N + V
     */



    double nx = x - 250;
    double ny = y - 250;
    double nd = Math.hypot(nx, ny);
    if (nd < 40){
        vx += Accelero.X * 0.1;
        vy += Accelero.Y * 0.1;
        x -= vx;
        y -= vy;
        vx *= 0.9;
        vy *= 0.9;
        return;
    }

    vx += Accelero.X * 0.1;
    vy += Accelero.Y * 0.1;


    if (nd == 0)
        nd = 1;
    nx /= nd;
    ny /= nd;
    double dotProduct = vx * nx + vy * ny;
    vx += (float) (-2 * dotProduct * nx);
    vy += (float) (-2 * dotProduct * ny);
    x -= vx * 2;
    y -= vy * 2;
    vx *= 0.99;
    vy *= 0.99;
}