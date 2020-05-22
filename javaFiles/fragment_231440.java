Class SomeExample {
  private boolean ignoreMouseMovedEvents = false;
  ...
  @Override
  public void mouseMoved(MouseEvent e) {
    if (ignoreMouseMovedEvents) {
      return; 
    }
    ... handle move events