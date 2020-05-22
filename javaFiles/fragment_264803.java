label.setOnMouseDragged(new EventHandler<MouseEvent>() {
    @Override public void handle(MouseEvent mouseEvent) {

      //Sets the drag boundaries limit
      double newX = mouseEvent.getSceneX() + dragDelta.x;
      if (newX > 200 || newX < 10) {
        return;
      }

      label.setLayoutX(mouseEvent.getSceneX() + dragDelta.x);
      label.setLayoutY(mouseEvent.getSceneY() + dragDelta.y);
    }
  });