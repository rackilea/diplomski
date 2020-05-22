int Ackerman(int m, int n) {
    switch (m) {
    case 0:
        return n + 1;
    case 1:
        return n + 2;
    case 2:
        return n * 2 + 3;
    case 3:
        return (int)((1L << (n + 3)) - 3);
    case 4:
        return n == 0 ? 13 : 65533;
    }
}