public boolean findPath(int x1, int y1, int x2, int y2) {
    if (x1 == x2 && y1 == y2)
        return true;
    else if (x1 > x2 || y1 > y2)
        return false;
    else
        return x1 > 0 && findPath(x1, x1 + y1, x2, y2)
            || y1 > 0 && findPath(x1 + y1, y1, x2, y2);
}