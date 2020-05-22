public static boolean twoQueensSeeEachOther(int x1, int y1, int x2, int y2) {
    if (x1 == x2 || y1 == y2) {
        return true;                                // One has picked another
    }
    if (x1 == x2 || y1 == y2) {
        return true;                                // Row or column
    }
    if (Math.abs(x1 - x2) == Math.abs(y1 - y2)) {
        return true;                                // Diagonal
    }
    return false;
}