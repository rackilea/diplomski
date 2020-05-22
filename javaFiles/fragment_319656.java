final EventHandler<WindowEvent> shownHandler = new EventHandler<WindowEvent>() {
  @Override
  public void handle(WindowEvent event) {
    System.out.println("Shown");
  }
};
Bindings.<Window>select(createUserDialog.sceneProperty(), "window").addListener(new ChangeListener<Window>() {

    @Override
    public void changed(ObservableValue<? extends Window> observable,
            Window oldValue, Window newValue) {
        if (oldValue != null) {
            oldValue.removeEventHandler(WindowEvent.WINDOW_SHOWN, shownHandler);
        }
        if (newValue != null) {
            newValue.addEventHandler(WindowEvent.WINDOW_SHOWN, shownHandler);
        }
    }

});