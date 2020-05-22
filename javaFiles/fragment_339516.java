class Monster {
    private ReadOnlyObjectWrapper<Point> location = new ReadOnlyObjectWrapper<>();
    private Timeline timeline;

    public Monster(int x, int y) {
        setLocation(new Point(x, y));

        timeline = new Timeline(new KeyFrame(Duration.seconds(1), event -> {
            setX(getLocation().x + 1);
        }));
        timeline.setCycleCount(Timeline.INDEFINITE);
    }

    public void start() {
        timeline.play();
    }

    // NOTE: remember to call stop() or this will result in a memory leak
    public void stop() {
        timeline.stop();
    }

    public Point getLocation() {
        return this.location.get();
    }

    private void setLocation(Point location) {
        this.location.set(location);
    }

    public ReadOnlyProperty<Point> locationProperty() {
        return this.location.getReadOnlyProperty();
    }

    private void setY(int newY) {
        this.setLocation(new Point(this.getLocation().x, newY));
    }

    private void setX(int newX) {
        this.setLocation(new Point(newX, this.getLocation().y));
    }
}