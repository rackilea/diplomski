@WithStateMachine
public class Bean2 {

  @OnTransition(source = "S1", target = "S2")
  public void method1(@EventHeaders Map<String, Object> headers, ExtendedState extendedState) {
  }

}