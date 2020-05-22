class Player {
    private final String name;
    private int points;

    ....

    public int getPoints() {
        return points;
    }  

    @Override
    public String toString() {
        return String.format("%s: %d", name, points);
    }
}