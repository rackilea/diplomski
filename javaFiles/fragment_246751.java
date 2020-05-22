@Push
public class App extends UI {

  @Override
  public void init(VaadinRequest request) {
    timer.schedule(new TimerTask() {
      public void run() {
        access(() -> grid.addRow("Example", "99"));
      }
    }, 1000, 1000);
  }
}