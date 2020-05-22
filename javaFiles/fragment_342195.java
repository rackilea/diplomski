public static enum Direction {
    LEFT(-1), RIGHT(1);

    private int delta;

    private Direction(int delta) {
        this.delta = delta;
    }

    public int getDelta() {
        return delta;
    }

}