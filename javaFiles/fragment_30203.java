static boolean isLegalMove(Point from, Point to) {
    boolean legal = false;
    for (Point p : getNeighbours(from)) {
        if (p.equals(to)) {
            legal = true;
            break;
        }
    }
    return legal;
}