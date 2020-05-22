private static class Delta {

    private double dragDeltaX;
    private double dragDeltaY;

    public double getDragDeltaX() {
        return dragDeltaX;
    }

    public double getDragDeltaY() {
        return dragDeltaY;
    }

    public void setDragDelta(double x, double y) {
        this.dragDeltaX = x;
        this.dragDeltaY = y;
    }
}

@Override
public void start(Stage primaryStage) {
    Circle c = new Circle(30);
    c.setLayoutX(50);
    c.setLayoutY(50);

    Pane root = new Pane(c);

    Delta dragDelta = new Delta();

    c.setOnMousePressed(event1 -> {
        Point2D mouseInParent = c.localToParent(event1.getX(), event1.getY());
        dragDelta.setDragDelta(c.getLayoutX() - mouseInParent.getX(), c.getLayoutY()-mouseInParent.getY());
        event1.consume();
    });

    c.setOnMouseDragged(event1 -> {
        Point2D mouseInParent = c.localToParent(event1.getX(), event1.getY());
        c.setLayoutX(mouseInParent.getX() + dragDelta.getDragDeltaX());
        c.setLayoutY(mouseInParent.getY() + dragDelta.getDragDeltaY());
    });

    Scene scene = new Scene(root, 500, 500);

    primaryStage.setScene(scene);
    primaryStage.show();
}