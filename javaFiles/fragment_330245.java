public static final int HIGH_BIT = 1 << 31;

public static boolean isLessThan(int x, int y) {
    if (x == y) {
        return false;
    }
    if ((x & HIGH_BIT) != (y & HIGH_BIT)) {
        return (y & HIGH_BIT) == HIGH_BIT;
    }
    return isLessThan(x << 1, y << 1);
}