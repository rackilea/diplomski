public Point intersect(Line line) {
    double x = (line.b - this.b) / (this.m - line.m);
    double y = this.m * x + this.b;

    return new Point((int) x, (int) y);
}