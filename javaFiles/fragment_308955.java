setOnMouseDragged(new EventHandler<MouseEvent>() {
    @Override
    public void handle(MouseEvent mouseEvent) {
        double newX = mouseEvent.getX() + dragDelta.x;
        if (newX > 0 && newX < getScene().getWidth()) {
            setCenterX(newX);
        }
        double newY = mouseEvent.getY() + dragDelta.y;
        if (newY > 0 && newY < getScene().getHeight()) {
            setCenterY(newY);
        }
    }
});