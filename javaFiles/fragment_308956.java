setOnMouseDragged(new EventHandler<MouseEvent>() {
    @Override
    public void handle(MouseEvent mouseEvent) {
        double newX = mouseEvent.getX() + dragDelta.x;
        if (newX > 0 && newX < getParent().getLayoutBounds().getWidth()) {
            setCenterX(newX);
        }
        double newY = mouseEvent.getY() + dragDelta.y;
        if (newY > 0 && newY < getParent().getLayoutBounds().getHeight()) {
            setCenterY(newY);
        }
    }
});