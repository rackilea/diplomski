int digit(int x) {
    while (x > 9) {
        x /= 10;
    }
    return x;
}