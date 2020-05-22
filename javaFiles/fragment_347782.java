if (moveHistory != null) {
    SequentialTransition sequentialTransition = new SequentialTranstiion();
    for (int i = 1; i < moveHistory.size(); i++) {
        Point2D p1 = moveHistory.get(i - 1);
        Point2D p2 = moveHistory.get(i);
        PathTransition ptMove = new PathTransition();
        Line line = (new Line(
                p1.getX() * (getWidth() / SIZE) + getWidth() / SIZE / 2,
                p1.getY() * (getHeight() / SIZE) + (getHeight() / SIZE / 2),
                p2.getX() * (getWidth() / SIZE) + getWidth() / SIZE / 2,
                p2.getY() * (getHeight() / SIZE) + getHeight() / SIZE / 2));
        ptMove.setPath(line);
        ptMove.setNode(knightImageView);
        ptMove.setCycleCount(1);
        ptMove.setDuration(Duration.seconds(2));
        sequentialTransition.getChildren().add(ptMove);
    }
    sequentialTransition.play();
}