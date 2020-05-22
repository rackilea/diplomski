public class Main {
  private Model m;
  private EventListener listener;

  ... main() {
    m = new Model();
    listener = new EventListener();

    EventHandler eventHandler = new MyEventHandler();

    // set the event handler
    listener.setEventHandler(eventHandler);

    listener.start(m);
}

public class Model {
  // nothing to see here
}

public class EventListener() {

  private EventHandler handler = new DefaultEventHandler();

  public void start(final Model m) {
    // startup
    while (event.type != Event.Quit) {
      // get event
      handler.handleEvent(event, m);
    }
    // shutdown
  }

  public void setEventHandler(EventHandler eh) { this.handler = eh }
}

public class MyEventHandler implements EventHandler {

  public void handleEvent(Event e, Model m) {
    // update the model
  }

}