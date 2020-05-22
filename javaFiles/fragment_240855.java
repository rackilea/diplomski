public void move() {

    if (100 <= x && x < getWidth() - 100 && y == 100)
        x = x + 1;
    if (x == getWidth() - 100 && 100 <= y && y < getHeight() - 100)
        y = y + 1;
    if (100 < x && x <= getWidth() - 100 && y == getHeight() - 100)
        x = x - 1;
    if (x == 100 && 100 < y && y <= getHeight() - 100)
        y = y - 1;
}