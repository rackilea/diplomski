Collections.sort(points, (a, b) -> {
    double cotanA = -(a.getX() - initial.getX()) / (a.getY() - initial.getY());
    double cotanB = -(b.getX() - initial.getX()) / (b.getY() - initial.getY());
    if (cotanA - cotanB < 0) {
        return 1;
    }
    return -1;
});