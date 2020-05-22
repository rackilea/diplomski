public class MyPart {
  @Inject
  @Optional
  public void event( @UIEventTopic(EVENT) EventParam param ) {
    new MyEventHandler().handleEvent( this, param );
  }
}

class MyEventHandler { 
  void handleEvent(MyPart part, EventParam param) {
    // all code from event() goes here
  }
}