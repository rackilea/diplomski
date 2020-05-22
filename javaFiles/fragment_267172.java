private static void calculate(int startX, int startY, int endX, int endY) {
    int amount = 8;

    // Compute the distance to each point
    double wholeDistanceX = endX - startX;
    double distanceX = wholeDistanceX / (amount + 1);

    double wholeDistanceY = endY - startY;
    double distanceY = wholeDistanceY / (amount + 1);

    // Add all new points
    for (int i = 1; i <= amount; i++) {
        // Compute current point
        double currentX = startX + i * distanceX;
        double currentY = startY + i * distanceY;

        // Create the point
        coordinates.add((int) currentX + "," + (int) currentY);
    }
}