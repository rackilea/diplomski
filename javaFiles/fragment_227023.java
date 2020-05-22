class Position {
    private final int x;
    private final int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public static Position interpolatedPosition(Position from, Position to, float progress) {
        return new Position(
            from.x + Math.round(progress * (to.x - from.x)), 
            from.y + Math.round(progress * (to.y - from.y)));
    }
}