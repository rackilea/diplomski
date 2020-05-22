// right and left wall collision
    if (x + xSpeed > this.getWidth() - radius - 1) {
        x = this.getWidth() - radius - 1;
        xSpeed = -xSpeed;
    } else if (x + xSpeed < 0 + radius) {
        x = 0 + radius;
        xSpeed = -xSpeed;
    } else
        x += xSpeed;

    if (y == this.getHeight() - radius - 1 
        && ySpeed == 0) { // Check speed too here!
        // Do nothing for Y.
        // friction with the ground
        xSpeed *= xFriction;
        if (Math.abs(xSpeed) < .4)
            xSpeed = 0
    }
    else if (y > this.getHeight() - radius - 1) {
        y = this.getHeight() - radius - 1;
        ySpeed *= energyLoss;
        if (Math.abs(ySpeed) < SomeMinimumValue)
            ySpeed = 0;
        else // invert speed, i.e. change direction.
            ySpeed = -ySpeed;

        // friction with the ground
        xSpeed *= xFriction;
        if (Math.abs(xSpeed) < .4)
            xSpeed = 0;

    } else {
        ySpeed += gravity * dt; // velocity formula
        y += ySpeed * dt + .5 * gravity * dt * dt; // position formula
    }

    repaint();