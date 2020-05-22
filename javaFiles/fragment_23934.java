public Point[] deepCopy(Point[] array) {
    Point[] copy = new Point[array.length];
    for (int i = 0; i < array.length; i++) {
        copy[i] = new Point(array[i]);
    }
    return copy;
}