// Some other thread
myView.post(new Runnable() {
  public void run() {
    // perform action in ui thread, presumably involving this view
  }
});