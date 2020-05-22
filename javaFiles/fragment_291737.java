// variable never updated so there are no issues with synchronisation
private final double radius = 20;

...

protected void moveBall() {
    // do updates on the JavaFX application thread
    Platform.runLater(() -> {
        if (x - radius <= 0 || x + radius >= 400) {
            dx *= -1;
        }

        if (y - radius <= 0 || y + radius >= 300) {
            dy *= -1;
        }

        x += dx * speed;
        y += dy * speed;
        circle.setCenterX(x);
        circle.setCenterY(y);
    });
}