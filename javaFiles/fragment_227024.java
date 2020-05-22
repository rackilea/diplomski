class Path {
    private final List<Position> positions = new ArrayList<>();
    private int currentPosition = 0;
    private float progress = 0.0f;
    private float speed = 0.1f;

    public void addPosition(Position position) {
        positions.add(position);
    }

    public void update() {
        progress += speed;
        while (progress > 1.0f) {
            currentPosition = nextPosition();
            progress -= 1.0f;
        }
    }

    public Position getCurrentPosition() {
        return Position.interpolatedPosition(positions.get(currentPosition), positions.get(nextPosition()), progress);
    }

    private int nextPosition() {
        return (currentPosition + 1) % positions.size();
    }

}