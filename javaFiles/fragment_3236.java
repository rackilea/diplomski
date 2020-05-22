private Path constructionPath = null;
private final Map<Color, Color> nextColor;

{
    // create map for modifying color
    nextColor = new HashMap<>();
    Color[] colors = new Color[] { Color.BLACK, Color.RED, Color.GREEN, Color.BLUE };
    for (int i = 0; i < colors.length - 1; i++) {
        nextColor.put(colors[i], colors[i+1]);
    }
    nextColor.put(colors[colors.length-1], colors[0]);
}

private void createCircle(MouseEvent evt, Pane canvas) {
    Circle circle = new Circle(evt.getX(), evt.getY(), 5, Color.WHITE);
    circle.setStroke(Color.BLACK);
    circle.setStrokeWidth(2.5);

    // circle dragging events
    class DragListener implements EventHandler<MouseEvent> {

        boolean dragging;
        double startX;
        double startY;

        @Override
        public void handle(MouseEvent event) {
            Point2D pt = circle.localToParent(event.getX(), event.getY());
            circle.setCenterX(pt.getX() + startX);
            circle.setCenterY(pt.getY() + startY);
            dragging = true;
        }
    }
    DragListener listener = new DragListener();
    circle.setOnMousePressed(event -> {
        if (event.getButton() == MouseButton.PRIMARY) {
            Point2D pt = circle.localToParent(event.getX(), event.getY());
            listener.startX = circle.getCenterX() - pt.getX();
            listener.startY = circle.getCenterY() - pt.getY();
        }
    });
    circle.setOnMouseReleased(event -> {
        if (event.getButton() == MouseButton.PRIMARY) {
            event.consume();
            if (listener.dragging) {
                listener.dragging = false;
            } else {
                if (constructionPath == null) {
                    // start new path
                    MoveTo move = new MoveTo();
                    move.xProperty().bind(circle.centerXProperty());
                    move.yProperty().bind(circle.centerYProperty());
                    constructionPath = new Path(move);
                    constructionPath.setStrokeWidth(2.5);
                    constructionPath.setOnMouseReleased(evt2 -> {
                        evt2.consume();
                        Path p = (Path) evt2.getSource();
                        p.setStroke(nextColor.get(p.getStroke()));
                    });
                    canvas.getChildren().add(0, constructionPath);
                } else {
                    // end path
                    LineTo line = new LineTo();
                    constructionPath.getElements().add(line);
                    line.xProperty().bind(circle.centerXProperty());
                    line.yProperty().bind(circle.centerYProperty());
                    constructionPath = null;
                }
            }
        }
    });
    circle.setOnMouseDragged(listener);

    canvas.getChildren().add(circle);
}