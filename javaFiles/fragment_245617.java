@ApplicationScoped
public class EventTest {
  @Inject Event<MyEvent> events;
  public void demo(){
      events.fire(new MyEvent());
  }
  public static void main(String[] args){
    Weld weld = new Weld();
    WeldContainer container = weld.initialize();
    EventTest test = container.select(EventTest.class).get();
    test.demo();
    container.shutdown();
  }
}