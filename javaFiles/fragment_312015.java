class Triangle implements Side {
    private Point a, b, c;

    // getters for a, b, c...
}

class Parallelogram implements Side {
    private Point a, b, c, d;

    // getters for a, b, c, d...
}

interface Side {
    // you don't know what to write here
}

class Plane {
    public void someMethod(Side side) {
        // this method needs at least 3 points, but if more points are
        // present, say 5, work with 5 points.
    }
}