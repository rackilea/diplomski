public Dimension getPreferredSize() {
    int width = Math.max(x1, x2) - Math.min(x1, x2);
    int height = Math.max(y1, y2) - Math.min(y1, y2);

    if (black) {
        width += 8;
        height += 8;
    } else {
        width += 3;
        height += 3;
    }

    return new Dimension(width, height);
}