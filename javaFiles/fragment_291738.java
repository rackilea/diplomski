public class Task3Ball {

    private Timeline timeline;

    ...

    protected void moveBall() {
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
    }

    public void startAnimation() {
        if (timeline == null) {
            // lazily create timeline
            timeline = new Timeline(new KeyFrame(Duration.millis(20), event -> moveBall()));
            timeline.setCycleCount(Animation.INDEFINITE);
        }

        // ensure the animation is playing
        timeline.play();
    }
}