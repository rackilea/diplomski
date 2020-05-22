circle.setOnMouseDragged((t) -> {
  double offsetX = t.getSceneX() - orgSceneX;
  double offsetY = t.getSceneY() - orgSceneY;

  // No idea why they are doing this. c is just circle
  Circle c = (Circle) (t.getSource());

  c.setTranslateX(c.getTranslateX() + offsetX);
  c.setTranslateY(c.getTranslateY() + offsetY);

  orgSceneX = t.getSceneX();
  orgSceneY = t.getSceneY();
});