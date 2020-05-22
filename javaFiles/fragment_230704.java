pane.setOnMouseClicked(e -> {
    if (e.getButton() == MouseButton.PRIMARY) {
        double X = e.getX(); // remove pane's coordinate system here
        double Y = e.getY(); // remove pane's coordinate system here
        final Circle circle = new Circle(X, Y, radius);
        circle.setFill(Color.WHITE);
        circle.setStroke(Color.BLACK);

        circle.setOnMouseClicked(evt -> {
            if (evt.getButton() == MouseButton.SECONDARY) {
                evt.consume();
                pane.getChildren().remove(circle);
            }
        });

        pane.getChildren().add(circle);
    }
});