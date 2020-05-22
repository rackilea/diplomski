class Ball {
    private final int id;
    private final double x, y;

    public Ball(int id, double x, double y) {
        this.id = id;
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "Ball{ id=" + id +"(x=" + x +", y=" + y + ") }";
    }
}