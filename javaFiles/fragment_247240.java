public class MyRule extends ExternalResource {
  static private MyRule instance;

  static public MyRule get() {
    if (instance == null) {
      instance = new MyRule();
    }

    return instance;
  }

  private MyRule() {
    // do init stuff

    Runtime.getRuntime().addShutdownHook(new Thread(() -> {
      // do shutdown stuff
    });
  }
}