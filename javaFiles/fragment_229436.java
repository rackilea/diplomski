public void translate(int dx, int dy, int end) {
    x += dx;
    y += dy;
    if (end == x) {
        x = -100;
    }
}