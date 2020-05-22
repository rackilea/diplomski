pane.setOnMouseClicked(e -> {
    if (e.getButton() == MouseButton.PRIMARY) {
        double X = e.getX(); // remove pane's coordinate system here
        double Y = e.getY(); // remove pane's coordinate system here
        Circle circle = new Circle(X, Y, radius);
        circle.setFill(Color.WHITE);
        circle.setStroke(Color.BLACK);

        pane.getChildren().add(circle);
    } else if (e.getButton() == MouseButton.SECONDARY) {
        // check if cicle was clicked and remove it if this is the case
        Node picked = e.getPickResult().getIntersectedNode();
        if (picked instanceof Circle) {
            pane.getChildren().remove(picked);
        }
    }
});