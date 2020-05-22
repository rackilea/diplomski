public int compare(int x, int y) {
    if (x&1 == y&1) {
        // Both numbers are odd or both numbers are even
        if (x&1 == 0) {
            // Both numbers are even: compare as usual
            return Integer.compare(x, y);
        } else {
            // Both numbers are odd: compare in reverse
            return Integer.compare(y, x);
        }
    }
    // One is odd, the other one is even
    if (x&1 == 0) {
        return -1;
    }
    return 1;
}