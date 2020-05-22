private Line createPath(BorderPane borderPane, PathTransition pathTransition) {
    Circle circle = (Circle)pathTransition.getNode();
    Line line = (Line)pathTransition.getPath();
    Random random = new Random();
    int endPosX = random.nextInt((int) borderPane.getWidth() - 30);
    int endPosY = random.nextInt((int) borderPane.getHeight() - 30);
    return new Line(line == null ? circle.getCenterX() : line.getEndX(), line == null ? circle.getCenterY() : line.getEndY(), endPosX, endPosY); // without discontinuities
    // return new Line(circle.getCenterX(), circle.getCenterY(), endPosX, endPosY); // with discontinuities
}