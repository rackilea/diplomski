void draw() {
    // New color to use if ball bounces
    r = random(255);
    b = random(255);
    g = random(255);

    background(64);

    yPos = yPos + vy;
    // Change x-position on each redraw
    xPos = xPos + vx;

    ellipse(xPos, yPos, 50, 50);

    // Variable indicating whether the ball bounced or not
    boolean bounced = false;

    // Out of bounds: left
    if (xPos <= 0) {
        vx = 2;
        bounced = true;
    // Out of bounds: right
    } else if (xPos >= 400) {
        vx = -2;
        bounced = true;
    }

    // Out of bounds: bottom
    if (yPos <= 0) {
        vy = 1;
        bounced = true;
    // Out of bounds: top
    } else if (yPos >= 300) {
        vy = -1;
        bounced = true;
    }

    // React to bounce if bounced
    if (bounced) {
        // Increase bounce-counter by one
        bounceCounter++;

        // Third bounce occurred
        if (bounceCounter == 3) {
            // Change the color
            fill(r, g, b);

            // Reset the counter
            bounceCounter = 0;
        }
    }
}