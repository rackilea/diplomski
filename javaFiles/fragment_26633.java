public class ThisEscape {

    private long[] aVeryBigArray = new long[4711 * 815];

    public ThisEscape(EventSource source) {
       source.registerListener( 
             new EventListener() {
                 public void onEvent(Event e) {
                     doSomething(e);
                 }
                 private void doSomething(Event e) {
                     System.out.println(e.toString());
                 }
             }
       );
    } 
}