Pane canvas = new Pane();
canvas.setOnMouseReleased(evt -> {
    if (evt.getButton() == MouseButton.PRIMARY) {
        if (constructionPath == null) {
            // create Circle
            createCircle(evt, canvas);
        } else {
            // add line to path
            LineTo line = new LineTo(evt.getX(), evt.getY());
            constructionPath.getElements().add(line);
        }
    }
});

canvas.setPrefSize(500, 500);