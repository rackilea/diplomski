// A new target is selected
if (Mouse.isButtonDown(0)) {

    targetX = Mouse.getX();
    targetY = Mouse.getY();
}

// Player is not standing on the target
if (targetX != X || targetY != Y) {

    // Get the vector between the player and the target
    int pathX = targetX - X;
    int pathY = targetY - Y;

    // Calculate the unit vector of the path
    double distance = Math.sqrt(pathX * pathX + pathY * pathY);
    double directionX = pathX / distance;
    double directionY = pathY / distance;

    // Calculate the actual walk amount
    double movementX = directionX * speed;
    double movementY = directionY * speed;

    // Move the player
    X = (int)movementX;
    Y = (int)movementY;
}