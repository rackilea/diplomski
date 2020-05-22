for (int j = 0; j < sizeOfShip; j++) {
    for (int k = 0; k < ship.getSize(); k++) {
        if (testX == currentX && testY == currentY) {
            return false;
        }
        if (ship.rotated)
            currentX++;
        else {
            currentY++;
        }
    }
    currentX = ship.getX();
    currentY = ship.getY();
    testX++;
}