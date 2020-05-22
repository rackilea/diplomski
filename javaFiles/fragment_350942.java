pane.setOnKeyPressed(e -> {
    switch (e.getCode()) {
        case UP: moveUp(); break;
        case DOWN: moveDown(); break;
        case LEFT: moveLeft(); break;
        case RIGHT: moveRight(); break;
        case Q: primaryStage.close(); break;
    }
});