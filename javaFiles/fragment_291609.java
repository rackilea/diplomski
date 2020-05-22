x += dx;
    y += dy;

    if (x < 0 || x > bounds.width) {
        dx = -dx;
        x += dx;
    }
    if (y < 0 || y > bounds.height) {
        dy = -dy;
        y += dy;
    }