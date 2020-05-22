tileActor.addListener(new DragListener() {
  private float offsetX, offsetY;

  @Override
  public void dragStart(InputEvent event, float x, float y, int pointer) {
    Actor target = event.getTarget();
    this.offsetX = event.getStageX() - target.getX();
    this.offsetY = event.getStageY() - target.getY();
  }

  @Override
  public void drag(InputEvent event, float x, float y, int pointer) {
    event.getTarget().setPosition(event.getStageX() - offsetX, event.getStageY() - offsetY);
  }
});