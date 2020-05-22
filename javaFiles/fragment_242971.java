public interface State {
  void f();
  void g();
  void h();
}

public class StateA : State {
  public void f() { do something; }
  ...
}

public class StateB : State {
  public void f() { do something else; }
  ...
}