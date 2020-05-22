class Ball extends Pane{
    public double radius = 20;
    private double x = 0;
    private double y = 0;
    private final double dx = 5, dy = 5;
    private Circle circle = new Circle(radius, radius, radius);
    private TranslateTransition animation;

    public Ball() {
        circle.setFill(Color.GREEN);
        getChildren().add(circle);
        animation = new TranslateTransition(Duration.millis(200), circle);
    }

    protected void moveLeft() {
        animation.setFromX(x); animation.setFromY(y);
        animation.setToX(x - dx);
        x -= dx;
        animation.play();
    }
    protected void moveRight() {
        animation.setToX(x+dx);
        x += dx;
        animation.play();
    }
    protected void moveUp() {
        animation.setToY(y-dy);
        y -= dy;
        animation.play();
    }
    protected void moveDown() {
        animation.setToY(y+dy);
        y += dy;
        animation.play();
    }
}