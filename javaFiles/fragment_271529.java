// Add a Java callback object to a WebEngine document once it has loaded.
webEngine.getLoadWorker().stateProperty().addListener(
  new ChangeListener<State>() {  
    @Override public void changed(ObservableValue<? extends State> ov, State oldState, State newState) {
      if (newState == State.SUCCEEDED) {
        JSObject win = (JSObject) webEngine.executeScript("window");
        win.setMember("app", new JavaApp());
      }
    }
  });
}
...
// JavaScript interface object
private class JavaApp {
  public void exit() {
    Platform.exit();
  }
}