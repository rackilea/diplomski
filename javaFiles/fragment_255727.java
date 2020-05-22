stackPane.setOnMousePressed(new EventHandler<MouseEvent>() {
    @Override
    public void handle(MouseEvent mouseEvent) {
        // record a delta distance for the drag and drop operation.
        dragDelta.x = primaryStage.getX() - mouseEvent.getScreenX();
        dragDelta.y = primaryStage.getY() - mouseEvent.getScreenY();
    }
});