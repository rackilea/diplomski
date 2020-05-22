class Point {

    public int x = 0; // line 1
    public int y = 0; // line 2

    public Point(int x, int y) { // line 3
        x = this.x; // line 4
        this.y = y; // line 5
    }
}