public class Main 
{
  private class MyListener extends MouseAdapter { ...}

  public Main() {
    class Listener1 extends MouseAdapter { ... }
    someSwingComponent.addMouseListener(new MyListener()); // inner class
    someSwingComponent.addMouseListener(new Listener1()); // local class
    someSwingComponent.addFocusListener(new FocusAdapter() { ... }); // anonymous
  }
}