class GameWindow {
  GameWindow() {...}
  protected void methodOnlyforEngine() {...}
  ...
}
class Engine {
  private class GameWindowProxy extends GameWindow {
     GameWindowProxy(GameWindow ex) { super();...}
  }

  private final GameWindowProxy proxy;
  Engine(GameWindow window) {
     proxy = new GameWindowProxy(window);
  }
  ...
  proxy.methodOnlyforEngine(); 
}