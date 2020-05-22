class Point {
    final int x;
    final int y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Monster implements Runnable {
    private ReadOnlyObjectWrapper<Point> location = new ReadOnlyObjectWrapper<>();

    public Monster(int x, int y) {
        setLocation(new Point(x, y));
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

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // run the update on the FX Application Thread for thread safety as well as to prevent errors in certain cases
            Platform.runLater(() -> this.setX(this.getLocation().x + 1));
        }
    }
}

monsterThread = new Thread(monster1);
monsterThread.start();
monsterImageView1.xProperty().bind(Bindings.createIntegerBinding(() -> monster1.getLocation().x * scale, monster1.locationProperty()));
monsterImageView1.yProperty().bind(Bindings.createIntegerBinding(() -> monster1.getLocation().y * scale, monster1.locationProperty()));
root.getChildren().add(monsterImageView1);