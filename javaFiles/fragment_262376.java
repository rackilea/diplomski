public void moveWithTimer() {
    int x = circ.getX();
    int y = circ.getY();

    x = x + b;
    y = y + a;
    if (x < 0) {
        b = 5;
    }

    if (x + 50 > 500) {
        b = -5;
    }

    if (y < 0) {
        a = 5;
    }

    if (y + 50 > 500) {
        a = -5;
    }

    circ.setX(x);
    circ.setY(y);

}