public static int mult(int x, int y) {
        if (y == 0) {
            return 0;
        }
        if (y > 0) {
            return x + mult(x, y - 1);
        } else {
            return -x + mult(x, y + 1);
        }
    }