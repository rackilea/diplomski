public Point() {
}

public Point(int x, int y, int t) {
    this.x = x;
    this.y = y;
    this.TYPE = t;
}

@Override
public String toString() {
    return x + ", " + y;
}