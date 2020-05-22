abstract class BasicListener {
  protected void handleThrowable(Component.Event event, Throwable throwable) {
    Window window = event.getComponent().getWindow();
    if (window instanceof ExceptionHandlingWindow) {
      ((ExceptionHandlingWindow) window).handleException(throwable);
    } else {
      // Log it ? DO something, anyway.
    }
  }
}

abstract class ExceptionHandlingButtonClickHandler extends BasicListener implements Button.ClickListener {
  @Override
  public void buttonClick(Button.ClickEvent event) {
    try {
      handleClick(event);
    } catch (Throwable e) {
      handleThrowable(event, e);
    }
  }

  protected abstract void handleClick(Button.ClickEvent event);
}

Button btnNew = new Button("New", new ExceptionHandlingButtonClickHandler() {
  @Override
  protected void handleClick(Button.ClickEvent event) {
    doThingThatThrowsException();
  }
});