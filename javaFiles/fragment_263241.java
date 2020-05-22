from("activemq:SomeQueue").
  bean(MyClass.class);

public class MyBean{
  public void handleEvent(MyEventObject eventPayload){ // Given MyEventObject was sent to this "SomeQueue".
     // whatever processing.
  }
}