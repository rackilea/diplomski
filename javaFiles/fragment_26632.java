public class ThisEscape {
    private String prefixText = null;

    private void doSomething(Event e) {
        System.out.println(prefixText.toUpperCase() + e.toString());
    }

    public ThisEscape(EventSource source) {
       source.registerListener( 
             new EventListener() {
                 public void onEvent(Event e) {
                     doSomething(e); // hidden reference to `ThisEscape` is used
                 }
             }
       );

       // What if an event is fired at this point from another thread? 
       // prefixText is not yet assigned, 
       // and doSomething() relies on it being not-null

       prefixText = "Received event: ";
    }
}