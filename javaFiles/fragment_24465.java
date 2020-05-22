// create just an instance of the timer
final MyUpdateTitleTimer mytimer = new MyUpdateTitleTimer();
// To Start the updater
mytimer.setPrefix("> ");
// To Stop set the prefix to null
mytimer.setPrefix(null);


class MyUpdateTitleTimer extends Timer {
  private String prefix;
  private String title;
  private boolean b;

  public void run() {
    String s = (b = !b) ? prefix + title : title;
    Window.setTitle(s);
  }

  public void setPrefix(String prefix) {
    if (title != null) {
      Window.setTitle(title);
    }
    this.prefix = prefix;
    if (prefix == null) {
      cancel();
    } else {
      title = Window.getTitle();
      scheduleRepeating(300);
    }
  }
}