pane.setOnMouseClicked(evt -> {
    Circle circle = ...

    pane.getChildren().add(circle);

    circle.setOnMouseClicked(event -> {
        event.consume();
        // TODO: circle specific event handling
    });
});