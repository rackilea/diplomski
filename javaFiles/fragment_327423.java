public enum Direction {
    UP(-1), DOWN(1), LEFT(-2), RIGHT(2);

    int vector;

    Direction(int i) {
        this.vector = i;
    }

    public boolean isOpposite(Direction d) {
        return this.vector + d.vector == 0;
    }

}