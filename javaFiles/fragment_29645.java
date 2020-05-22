double distance(int x1, int y1, int x2, int y2) {
    int dx = abs(x2 - x1);
    int dy = abs(y2 - y1);

    int min = min(dx, dy);
    int max = max(dx, dy);

    int diagonalSteps = min;
    int straightSteps = max - min;

    return sqrt(2) * diagonalSteps + straightSteps;
}