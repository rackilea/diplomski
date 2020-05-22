public static boolean isLessThan(int x, int y) {
    if (y == 0) {
        return false;
    }
    if (x == 0) {
        return true;
    }

    return isLessThan(x - 1, y - 1);
}